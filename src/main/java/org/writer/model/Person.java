package org.writer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.writer.annotation.CsvColumn;

@Data
@Builder
@AllArgsConstructor
public class Person {

    @CsvColumn(name = "First name")
    private String firstName;

    @CsvColumn(name = "Last name")
    private String lastName;

    @CsvColumn(name = "Day of birth")
    private int dayOfBirth;

    @CsvColumn(name = "Month of birth")
    private Months monthOfBirth;

    @CsvColumn(name = "Year of birth")
    private int yearOfBirth;

}
