package com.javarzn.training.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Инициализация контекста с конструктором с параметрами.
 *
 * @author Konstantin
 */
public class Launcher03 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/beans.xml");
    }
}
