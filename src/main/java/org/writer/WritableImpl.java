package org.writer;

import org.writer.annotation.CsvColumn;
import org.writer.exception.NoDataCSVException;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class WritableImpl implements Writable {

    @Override
    public void writeToFile(List<?> data, String fileName) throws IOException {
        if (data == null || data.isEmpty()) throw new NoDataCSVException();

        Class<?> clazz = data.get(0).getClass();
        List<Field> fields = List.of(clazz.getDeclaredFields());

        String header = fields.stream()
                .filter(field -> field.isAnnotationPresent(CsvColumn.class))
                .map(field -> field.getAnnotation(CsvColumn.class).name())
                .collect(Collectors.joining(","));
        header += "\n";

        String rows = data.stream()
                .map(obj -> fields.stream()
                        .filter(field -> field.isAnnotationPresent(CsvColumn.class))
                        .map(field -> {
                            try {
                                field.setAccessible(true);
                                var value = field.get(obj);
                                return String.valueOf(value);
                            } catch (IllegalAccessException e) {
                                return "NO_ACCESS";
                            }
                        }).collect(Collectors.joining(","))
                ).collect(Collectors.joining("\n"));
        String csv = header + rows;

        try (var fileWriter = new FileWriter(fileName)) {
            fileWriter.write(csv);
        }
    }
}
