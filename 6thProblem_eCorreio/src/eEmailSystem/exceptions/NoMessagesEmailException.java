package eEmailSystem.exceptions;

public class NoMessagesEmailException extends Exception {
    // Constants
    private static final String ERROR = "Nao existem mensagens trocadas com esse email.";

    public NoMessagesEmailException() {
        super();
    }

    public String getErrorInfo() {
        return ERROR;
    }
}
