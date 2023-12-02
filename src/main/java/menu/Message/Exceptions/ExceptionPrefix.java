package menu.Message.Exceptions;

public enum ExceptionPrefix {
    ERROR_PREFIX("[ERROR] ");

    private final String message;

    ExceptionPrefix(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
