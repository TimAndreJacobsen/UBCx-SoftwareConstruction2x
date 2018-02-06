package model.exceptions;


public class BeansAmountException extends Exception{

    private double beans;

    public BeansAmountException(double beans) {
        super(beans + " is not the right amount of beans!");

    }

    protected BeansAmountException(double beans, String msg) {
        super("Beancount: " + beans +"\n" + msg);
    }

    public double getBeans() {
        return beans;
    }



}
