package topic15.practice;

public class StepException extends RuntimeException {
    public StepException(String message) {
        super(message);
    }
    public StepException(String message, Throwable cause){
        super(message,cause);
    }
}
