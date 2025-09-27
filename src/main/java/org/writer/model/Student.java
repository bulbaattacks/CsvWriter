package org.writer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.writer.annotation.CsvColumn;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Student {

    @CsvColumn(name = "Student name")
    private String name;

    @CsvColumn(name = "Student score")
    private List<String> score;
}