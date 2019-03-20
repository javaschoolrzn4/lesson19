package com.javarzn.training.context;

public class MyTestClass2 {
    private Integer someValue;
    private String someString;

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public Integer getSomeValue() {
        return someValue;
    }

    public void setSomeValue(Integer someValue) {
        this.someValue = someValue;
    }

    public void init() {
        System.out.println(getSomeString());
        System.out.println(getSomeValue());
    }
}
