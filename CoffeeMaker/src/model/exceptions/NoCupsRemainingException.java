package model.exceptions;

public class NoCupsRemainingException extends Exception {

    public NoCupsRemainingException() {
        super("Barista is out of cups to pour coffee in");
    }
}
