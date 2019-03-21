package com.javarzn.training.spel;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyTestClass {
    private String myStringProperty;

//    public MyTestClass(String myStringProperty) {
//        this.myStringProperty = myStringProperty;
//        System.out.println(this.myStringProperty);
//    }

    public void init() {
//        this.myStringProperty = myStringProperty;
        System.out.println(this.myStringProperty);
    }
}
