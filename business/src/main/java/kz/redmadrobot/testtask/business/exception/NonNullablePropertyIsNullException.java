package kz.redmadrobot.testtask.business.exception;

public class NonNullablePropertyIsNullException extends RuntimeException {
    public NonNullablePropertyIsNullException(String message) {
        super(message);
    }
}
