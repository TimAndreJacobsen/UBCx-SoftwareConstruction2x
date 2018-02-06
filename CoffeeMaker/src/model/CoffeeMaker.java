package model;

import model.exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int cups;
    private int coffeeAge;

    public CoffeeMaker(){
        cups = 0;
        coffeeAge = -1;
    }

    // getters
    public int getTimeSinceLastBrew() {
        return coffeeAge;
    }
    public int getCupsRemaining() {
        return cups;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        if (cups > 0) {
            return true;
        }
        return false;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        this.coffeeAge = time;
    }

    //REQUIRES: beans between 2.40 and 2.60 cups, water > 14.75 cups
    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    public void brew(double beans, double water) throws BeansAmountException, WaterException{
        // Double check that testing is catching edge cases
        // assuming between reads as non-inclusive for beans
        if (beans <= 2.4) { // Bug caught in testing! before "beans < 2.4"
            throw new NotEnoughBeansException(beans);
        } else if (beans > 2.6) {
            throw new TooManyBeansException(beans);
        } else if (water <= 14.75) { // Bug I didn't catch in testing! before "water < 14.75"
            throw new WaterException(water);
        }

        this.cups = 20;
        this.coffeeAge = 0;
    }

    ///REQUIRES: cups remaining > 0, time since last brew < 60
    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException {
        if (getCupsRemaining() <= 0) {
            throw new NoCupsRemainingException();
        } else if (getTimeSinceLastBrew() > 60) {
            throw new StaleCoffeeException(getTimeSinceLastBrew());
        }
        cups -= 1;
    }
}
