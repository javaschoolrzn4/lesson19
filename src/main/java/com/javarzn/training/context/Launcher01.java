package com.javarzn.training.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Точка входа в приложение, тут поднимается контекст спринга.
 *
 * @author Konstantin
 */
public class Launcher01 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    }
}
