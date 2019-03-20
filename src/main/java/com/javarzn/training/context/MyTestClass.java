package com.javarzn.training.context;

public class MyTestClass {
    private Double piValue;
    private Double randomNumber;
    
    public Double getPiValue() {
        return piValue;
    }

    public void setPiValue(Double piValue) {
        this.piValue = piValue;
    }

    public Double getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Double randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void printValue() {
        System.out.println(getPiValue());
        System.out.println(getRandomNumber());
    }
}
