package main;

import model.CoffeeMaker;
import model.exceptions.*;

public class Main {

    public static void main(String[] args) {
        // TODO: complete the implementation of Main


        // Successful Path! beans 2.4<->2.6, water >14.75
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        try {
            coffeeMaker.brew(2.5, 15.0);

        } catch (BeansAmountException e) {
            e.printStackTrace();
            e.getMessage();

        } catch (WaterException e) {
            e.printStackTrace();
            e.getMessage();
        }

        coffeeMaker.setTimeSinceLastBrew(10);

        try {
            coffeeMaker.pourCoffee();

        } catch (NoCupsRemainingException e) {
            e.printStackTrace();
            System.out.println("No cups remaining");
            e.getMessage();

        } catch (StaleCoffeeException e) {
            e.printStackTrace();
            System.out.println("Coffee has gone stale");
            e.getMessage();
        }


        // Unsuccessful path!
        CoffeeMaker cm2 = new CoffeeMaker();

        try {
            coffeeMaker.brew(1,5);
        } catch (BeansAmountException e) {
            e.printStackTrace();
            e.getMessage();

        } catch (WaterException e) {
            e.printStackTrace();
            e.getMessage();
        }

        try {
            cm2.brew(2.5, 16.0);
        } catch (BeansAmountException e) {
            e.printStackTrace();
            e.getMessage();

        } catch (WaterException e) {
            e.printStackTrace();
            e.getMessage();
        }

        cm2.setTimeSinceLastBrew(50);
        try {
            cm2.pourCoffee();
        } catch (NoCupsRemainingException e) {
            e.printStackTrace();
            e.getMessage();

        } catch (StaleCoffeeException e) {
            e.printStackTrace();
            e.getMessage();
        }

        cm2.setTimeSinceLastBrew(70);
        try {
            cm2.pourCoffee();
        } catch (NoCupsRemainingException e) {
            e.printStackTrace();
            e.getMessage();

        } catch (StaleCoffeeException e) {
            e.printStackTrace();
            e.getMessage();
        }


    }
}