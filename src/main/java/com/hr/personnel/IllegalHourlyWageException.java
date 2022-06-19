package com.hr.personnel;

public class IllegalHourlyWageException extends RuntimeException {
    public IllegalHourlyWageException(String message) {
        super(message);
    }
    public IllegalHourlyWageException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalHourlyWageException(Throwable cause) {
        super(cause);
    }
}
