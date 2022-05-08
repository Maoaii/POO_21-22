package exceptions;

public class EmptyStringException extends Exception {
    private String error;

    public EmptyStringException(String info) {
        error = info;
    }

    public String getErrorInfo() {
        return error;
    }
}
