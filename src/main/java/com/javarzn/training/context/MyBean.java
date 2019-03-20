package com.javarzn.training.context;

public class MyBean {
    public MyBean() {
        System.out.println("I love Spring!");
    }

    public MyBean(String name) {
        System.out.println("Hello " + name + "!");
    }

    public MyBean(BeanAsParameter beanAsParameter) {
        System.out.println("Hello " + beanAsParameter.getHelloParameter() + "!");
    }

    public void printHelloWorld() {
        System.out.println("Hello World!");
    }
}
