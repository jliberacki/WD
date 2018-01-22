package exception;

public class InvalidDataExcepetion extends Exception{
    public String getMessage() {
        return "Nie znalazlem podanych danych";
    }
}

