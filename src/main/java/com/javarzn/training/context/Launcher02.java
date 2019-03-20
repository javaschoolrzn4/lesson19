package com.javarzn.training.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Инициализация контекста, получение бина и вызов метода.
 *
 * @author Konstantin
 */
public class Launcher02 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/beans.xml");
        MyBean performer = (MyBean) context.getBean("MyBean");
        performer.printHelloWorld();
    }
}
