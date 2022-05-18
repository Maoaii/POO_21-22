package eEmailSystem.exceptions;


public class NoMessagesSubjectException extends Exception {
    // Constants
    private static final String ERROR = "Nao existem mensagens trocadas com esse assunto.";

    public NoMessagesSubjectException() {
        super();
    }

    public String getErrorInfo() {
        return ERROR;
    }
}
