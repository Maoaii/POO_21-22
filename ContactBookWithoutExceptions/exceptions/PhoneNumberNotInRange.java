package exceptions;

public class PhoneNumberNotInRange extends Exception{
    private String error;
    public PhoneNumberNotInRange(String info) {
        error = info;
    }

    public String getErrorInfo() {
        return error;
    }
}
