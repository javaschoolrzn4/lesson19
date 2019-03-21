package com.javarzn.training;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Properties;

/**
 * Спринг берет на себя функцию этого класса, этот класс можно смело удалять, оставив только имя бина.
 */
@Getter
@Setter
public class AppConfig {
    private Properties properties;
    private String myStringProperty;
    private List<String> myPropertyList;

    public void init() {
        System.out.println(properties.getProperty("scan.directory"));
    }

    public void example() {
        System.out.println(properties.getProperty("scan.directory"));
        System.out.println("Установленное выражение: " + getMyStringProperty());
        for (String item: getMyPropertyList()) {
            System.out.println("Элемент списка: " + item);
        }
    }

    public void spelExample() {
        System.out.println("Пример скопированного значения из другого бина: " + getMyStringProperty());
    }

    public String getTestString() {
        return "sss";
    }

}
