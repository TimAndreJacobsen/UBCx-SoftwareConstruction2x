package model.exceptions;

public class StaleCoffeeException extends Exception {

    private int coffeeAge;

    public StaleCoffeeException(int coffeeAge) {
        super(coffeeAge + " is too old and stale to be served!");
    }

}
