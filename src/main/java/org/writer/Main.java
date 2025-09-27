package org.writer;

import org.writer.model.Student;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> students = Arrays.asList(
                Student.builder()
                        .name("Alex")
                        .score(Arrays.asList("1", "2"))
                        .build(),
                Student.builder()
                        .name("Max")
                        .score(Arrays.asList("2", "3"))
                        .build()
        );

        Writable csvWriter = new WritableImpl();
        csvWriter.writeToFile(students, "students");
    }
}