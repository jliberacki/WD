package exception;

public class InvalidLoginOrPasswordException extends  Exception {
    public String getMessage() {
        return "Nieprawidlowy login lub haslo";
    }
}
