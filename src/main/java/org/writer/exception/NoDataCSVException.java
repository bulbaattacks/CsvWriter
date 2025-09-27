package org.writer.exception;

public class NoDataCSVException extends RuntimeException {
    public static final String MSG = "There is no data to write to CSV";

    public NoDataCSVException() {
        super(MSG);
    }
}
