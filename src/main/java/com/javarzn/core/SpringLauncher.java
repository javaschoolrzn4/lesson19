package com.javarzn.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Точка входа в приложение, тут поднимается контекст спринга.
 *
 * @author Konstantin
 */
public class SpringLauncher {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:/taskBean.xml");
    }
}
