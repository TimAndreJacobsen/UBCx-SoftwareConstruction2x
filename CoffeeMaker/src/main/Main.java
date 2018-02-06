package main;

import model.CoffeeMaker;
import model.exceptions.*;

public class Main {

    /*
     * UBCx SoftwareConstruction2x - Module 1
     *
     * CoffeeMaker long form problem Solution
     * create robust software by using exceptions
     *
     * Valid amounts are:
     * beans 2.4<->2.6
     * water > 14.75
     *
     */


    public static void main(String[] args) {
        // Use case scenario: first a successful usage scenario, then an unsuccessful scenario


        // Successful usage
        CoffeeMaker cm = new CoffeeMaker();

        try {

            System.out.println("Brewing coffee");
            cm.brew(2.5, 15);
            System.out.println("Cups left: " + cm.getCupsRemaining() +
            "\nTime since fresh brew: " + cm.getTimeSinceLastBrew() + "\n");

            System.out.println("pouring a cup");
            cm.pourCoffee();

            System.out.println("taking a quick break");
            cm.setTimeSinceLastBrew(10);

            System.out.println("pouring some more cups");
            cm.pourCoffee();
            cm.pourCoffee();
            cm.pourCoffee();
            cm.setTimeSinceLastBrew(30);

            System.out.println("Wonder how how coffee is left and how long it was since i brewed it" +
                    "\nCups left: " + cm.getCupsRemaining() +
                    "\nTime since fresh brew: " + cm.getTimeSinceLastBrew() + "\n");

            System.out.println("refreshing the pot");
            cm.brew(2.5, 20);
            System.out.println("Cups left: " + cm.getCupsRemaining() +
                    "\nTime since fresh brew: " + cm.getTimeSinceLastBrew() + "\n");

        } catch (Exception e) {
            System.out.println("not expected");
        }


        // Unsuccessful usage
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        try {
            coffeeMaker.brew(2.5, 13.0);
        } catch (WaterException e) {
            System.out.println("expected, water");
        } catch (BeansAmountException e) {
            System.out.println("unexpected");
        }

        try {
            coffeeMaker.brew(2.1, 15);
        } catch (BeansAmountException e) {
            System.out.println("expected, beans");
        } catch (WaterException e) {
            System.out.println("unexpected");
        }

        try {
            coffeeMaker.brew(2.5, 15);
        } catch (BeansAmountException e) {
            System.out.println("unexpected");
        } catch (WaterException e) {
            System.out.println("unexpected");
        }

        for (int i = 0; i < 20; i++) {
            try {
                coffeeMaker.pourCoffee();
            } catch (NoCupsRemainingException e) {
                System.out.println("unexpected");
            } catch (StaleCoffeeException e) {
                System.out.println("unexpected");
            }
        }

        try {
            coffeeMaker.pourCoffee(); // 1 too many!
        } catch (NoCupsRemainingException e) {
            System.out.println("expected, no cups");
        } catch (StaleCoffeeException e) {
            System.out.println("unexpected");
        }

        try {
            coffeeMaker.brew(2.5, 15);
        } catch (BeansAmountException e) {
            System.out.println("unexpected");
        } catch (WaterException e) {
            System.out.println("unexpected");        }

        coffeeMaker.setTimeSinceLastBrew(61);

        try {
            coffeeMaker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println("unexpected");
        } catch (StaleCoffeeException e) {
            System.out.println("expected, stale coffee");
        }

        System.out.println();
        System.out.println("Barista went home for the day" +
        "\nCups Remaining: " + coffeeMaker.getCupsRemaining() +
        "\nTime since fresh brew: " + coffeeMaker.getTimeSinceLastBrew());

    }

}