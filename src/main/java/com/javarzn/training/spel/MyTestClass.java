package com.javarzn.training.spel;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyTestClass {
    private String myStringProperty;
    private String adjustedAmount;
    private String circumference;
    private String average;
    private String remainder;
    private String area;
    private String fullName;
    private double piValue;


//    public MyTestClass(String myStringProperty) {
//        this.myStringProperty = myStringProperty;
//        System.out.println(this.myStringProperty);
//    }

    public void init() {
        System.out.println(this.toString());
//        this.myStringProperty = myStringProperty;
//        System.out.println(this.myStringProperty);
//        System.out.println(this.piValue);
    }
}
