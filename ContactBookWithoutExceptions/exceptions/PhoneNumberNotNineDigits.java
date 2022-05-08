package exceptions;

public class PhoneNumberNotNineDigits extends  Exception{
    private String error;

    public PhoneNumberNotNineDigits(String info) {
        error = info;
    }

    public String getErrorInfo() {
        return error;
    }
}
