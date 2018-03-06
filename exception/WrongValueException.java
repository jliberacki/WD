package exception;

public class WrongValueException extends Exception {
    public String getMessage() {
        return "Ocena musi byc z przedialu 2.0-5.0 oraz byc wielokrotnoscia 0.5";
    }
}
