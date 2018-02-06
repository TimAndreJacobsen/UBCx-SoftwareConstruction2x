package model;

import model.exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int cups;
    private int CoffeeAge;

    public CoffeeMaker(){
        // cups = 0;
        // CoffeeAge = -1;
        // TODO: complete the implementation of this method
    }

    // getters
    public int getTimeSinceLastBrew() {
        // TODO: complete the implementation of this method
        return 0;
    }
    public int getCupsRemaining() {
        // TODO: complete the implementation of this method
        return 0;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        // TODO: complete the implementation of this method
        return false;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) throws IllegalArgumentException {
        // TODO: complete the implementation of this method
    }

    //REQUIRES: beans between 2.40 and 2.60 cups, water > 14.75 cups
    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    public void brew(double beans, double water) throws BeansAmountException, WaterException{
        // Can return bool for brew completed. assertTrue in test
        if (beans < 2.4) {
            throw new NotEnoughBeansException(beans);
        } else if (beans > 2.6) {
            throw new TooManyBeansException(beans);
        } else if (water < 14.75) {
            throw new WaterException(water);
        }

        // TODO: complete the implementation of this method
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



        // TODO: complete the implementation of this method
    }


}
