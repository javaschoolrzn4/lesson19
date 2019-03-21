package com.javarzn.training.context;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TwoContextLauncher {
    private static String classPathBeansPath = "classPathBeans.xml";
    private static String fileSystemBeansPath = "C:\\Users\\sbt-keglev-kn\\Desktop\\Лекция по Spring\\Core\\Исходный код\\SpringCore\\src\\main\\resources\\fileSystemBeans.xml";

    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(classPathBeansPath);
        ApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext(fileSystemBeansPath);
        // В этом месте у нас уже есть два контекста, в консоле дважды отписались сообщения - I love Spring!
        // Следующий блок отработает, так как бин есть в контексте
        MyBean classPathBean = (MyBean) classPathXmlApplicationContext.getBean("classPathContextBean");
        classPathBean.printHelloWorld();

        try {
            MyBean fileSystemBean = (MyBean) classPathXmlApplicationContext.getBean("fileSystemContextBean");
            fileSystemBean.printHelloWorld();
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Такой бин не представлен в контексте ClassPathXmlApplicationContext!");
        }

        // Следующий блок отработает, так как бин есть в контексте
        MyBean fileSystemContextBean = (MyBean) fileSystemXmlApplicationContext.getBean("fileSystemContextBean");
        fileSystemContextBean.printHelloWorld();
    }

}
