package recipes.exceiption;

public class ActionNotAllowException extends RuntimeException{
    private String message;

    public ActionNotAllowException(String message) {
        super(message);
        this.message = message;
    }

    public ActionNotAllowException() {
    }

    @Override
    public String getMessage() {
        return message;
    }
}
