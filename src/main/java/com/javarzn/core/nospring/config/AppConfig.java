package com.javarzn.core.nospring.config;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    public static final String FILE_NAME = "scan.properties";

    @Getter
    private Properties resource = new Properties();
    private InputStream inputStream = null;

    public AppConfig() {
        initResource();
    }

    private void initResource() {
        try {
            inputStream = AppConfig.class.getClassLoader().getResourceAsStream(FILE_NAME);
            if (inputStream == null) {
                System.out.println("Sorry, unable to find " + FILE_NAME);
                return;
            }
            resource.load(inputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
