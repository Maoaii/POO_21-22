package eEmailSystem.exceptions;

public class DuplicateMessageException extends Exception {
    // Constants
    private static final String ERROR = "Mensagem duplicada.";

    public DuplicateMessageException() {
        super();
    }

    public String getErrorInfo() {
        return ERROR;
    }
}
