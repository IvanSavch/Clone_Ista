package exeption;

public class DuplicateUserName extends Exception {
    public DuplicateUserName(String message) {
        super(message);
    }
}
