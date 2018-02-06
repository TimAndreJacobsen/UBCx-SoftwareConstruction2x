package test;

import model.CoffeeMaker;
import model.exceptions.BeansAmountException;
import model.exceptions.NoCupsRemainingException;
import model.exceptions.StaleCoffeeException;
import model.exceptions.WaterException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CoffeeMakerTest {

    CoffeeMaker coffeeMaker;

    @Before
    public void setUp(){
        // TODO: instantiate your test objects here
        coffeeMaker = new CoffeeMaker();
    }

    @Test
    public void testBrew() {
        //SETUP
        CoffeeMaker cmMin = new CoffeeMaker();
        CoffeeMaker cmRange = new CoffeeMaker();
        CoffeeMaker cmMax = new CoffeeMaker();

        //TEST
        try { // bottom boundary test case
            cmMin.brew(2.4,14.75);
        } catch (BeansAmountException e) {
            fail();
        } catch (WaterException e) {
            fail();
        }

        try {  // middle of range test case
            cmRange.brew(2.5, 20.0);
        } catch (BeansAmountException e) {
            fail();

        } catch (WaterException e) {
            fail();
        }

        try {  // upper boundary test case
            cmMax.brew(2.6,100.0);
        } catch (BeansAmountException e) {
            fail();
        } catch (WaterException e) {
            fail();
        }

        //VERIFY
        assertEquals(cmMin.getCupsRemaining(), 20);
        assertEquals(cmMin.getTimeSinceLastBrew(), 0);
        assertEquals(cmRange.getCupsRemaining(), 20);
        assertEquals(cmRange.getTimeSinceLastBrew(), 0);
        assertEquals(cmMax.getCupsRemaining(), 20);
        assertEquals(cmMax.getTimeSinceLastBrew(), 0);
    }

    @Test
    public void testBrewInvalidBeans() {
        //SETUP
        CoffeeMaker cmZero = new CoffeeMaker();
        CoffeeMaker cmMinRange = new CoffeeMaker();
        CoffeeMaker cmMinBoundary = new CoffeeMaker();
        CoffeeMaker cmMaxBoundary = new CoffeeMaker();
        CoffeeMaker cmMaxRange = new CoffeeMaker();

        //TEST
        try {  // special 0 case (might add for negative aswell)
            cmZero.brew(0,15);
        } catch (BeansAmountException e) {
            // expected exception
        } catch (WaterException e) {
            fail();
        }

        try {  // min range test case
            cmMinRange.brew(2,15);
        } catch (BeansAmountException e) {
            // expected exception
        } catch (WaterException e) {
            fail();
        }

        try {  // min boundary test case
            cmMinBoundary.brew(2.39,15);
        } catch (BeansAmountException e) {
            // expected exception
        } catch (WaterException e) {
            fail();
        }

        try {  // max boundary test case
            cmMaxBoundary.brew(2.61,15);
        } catch (BeansAmountException e) {
            // expected exception
        } catch (WaterException e) {
            fail();
        }

        try {  // max range test case
            cmMaxBoundary.brew(10,15);
        } catch (BeansAmountException e) {
            // expected exception
        } catch (WaterException e) {
            fail();
        }

        //VERIFY
        assertEquals(cmZero.getCupsRemaining(), 0);
        assertEquals(cmZero.getTimeSinceLastBrew(), -1);
        assertEquals(cmMinRange.getCupsRemaining(), 0);
        assertEquals(cmMinRange.getTimeSinceLastBrew(), -1);
        assertEquals(cmMinBoundary.getCupsRemaining(), 0);
        assertEquals(cmMinBoundary.getTimeSinceLastBrew(), -1);
        assertEquals(cmMaxBoundary.getCupsRemaining(), 0);
        assertEquals(cmMaxBoundary.getTimeSinceLastBrew(), -1);
        assertEquals(cmMaxRange.getCupsRemaining(), 0);
        assertEquals(cmMaxRange.getTimeSinceLastBrew(), -1);

    }

    @Test
    public void testBrewInvalidWater() {
        //SETUP
        CoffeeMaker minBoundary = new CoffeeMaker();

        //TEST
        try {
            coffeeMaker.brew(2.5, 10);
        } catch (BeansAmountException e) {
            fail();
        } catch (WaterException e) {
            // expected exception
        }

        try {
            minBoundary.brew(2.5, 14.74);
        } catch (BeansAmountException e) {
            fail();
        } catch (WaterException e) {
            // expected exception
        }

        //VERIFY
        assertEquals(coffeeMaker.getTimeSinceLastBrew(), -1);
        assertEquals(coffeeMaker.getCupsRemaining(), 0);
        assertEquals(minBoundary.getCupsRemaining(), 0);
        assertEquals(minBoundary.getTimeSinceLastBrew(),-1);
    }

    @Test
    public void testPourCoffeeOneCup() {
        // test that pourCoffee works while: cups > 0, coffeeAge <= 60
        // test that pourCoffee -= 1 for each call to pourCoffee()

        //SETUP
        testPourCoffee(); // common method between this method and testPourCoffeeManyCups()

        //TEST
        try {  // test 1 cup
            coffeeMaker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            fail();
        } catch (StaleCoffeeException e) {
            fail();
        }

        //VERIFY
        assertEquals(coffeeMaker.getCupsRemaining(), 19);
        assertEquals(coffeeMaker.getTimeSinceLastBrew(), 0);

    }

    @Test
    public void testPourCoffeeManyCups() {
        // test that pourCoffee works while: cups > 0, coffeeAge <= 60
        // test that pourCoffee -= 1 for each call to pourCoffee()

        //SETUP
        testPourCoffee();  // common method between this method and testPourCoffeeOneCup()

        //TEST
        for (int i = 0; i < 19; i++) {
            try {  // pour 19 more cups, expected 0
                coffeeMaker.pourCoffee();
            } catch (NoCupsRemainingException e) {
                fail();
            } catch (StaleCoffeeException e) {
                fail();
            }
        }

        //VERIFY
        assertEquals(coffeeMaker.getCupsRemaining(), 0);
        assertEquals(coffeeMaker.getTimeSinceLastBrew(), 0);
    }

    @Test
    public void testPourCoffeeThrowsCupException() {
        //SETUP
        try {
            coffeeMaker.brew(2.5,15);
        } catch (BeansAmountException e) {
            fail();
        } catch (WaterException e) {
            fail();
        }

        for (int i = 0; i < 20; i++) {
            try {
                coffeeMaker.pourCoffee();
            } catch (NoCupsRemainingException e) {
                fail(); // pour 20 cups, should be left at 0 after loop
            } catch (StaleCoffeeException e) {
                fail();
            }
        }

        //TEST
        try {
            coffeeMaker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            // Expected exception
        } catch (StaleCoffeeException e) {
            fail();
        }

        //VERIFY
        assertEquals(coffeeMaker.getCupsRemaining(), 0);
        assertEquals(coffeeMaker.getTimeSinceLastBrew(), 0);
    }

    @Test
    public void testPourCoffeeThrowsStaleException() {
        //SETUP
        try {
            coffeeMaker.brew(2.5,15);
        } catch (BeansAmountException e) {
            fail();
        } catch (WaterException e) {
            fail();
        }
        coffeeMaker.setTimeSinceLastBrew(61);

        //TEST
        try {
            coffeeMaker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            fail();
        } catch (StaleCoffeeException e) {
            // Expected exception
        }

        //VERIFY
        assertEquals(coffeeMaker.getCupsRemaining(), 20);
        assertEquals(coffeeMaker.getTimeSinceLastBrew(), 61);
    }

    @Test
    public void testPourCoffee() {
        // Helper method
        try {
            coffeeMaker.brew(2.5,15);
        } catch (BeansAmountException e) {
            fail();
        } catch (WaterException e) {
            fail();
        }
    }

}
