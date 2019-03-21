package com.javarzn.training.config;

import com.javarzn.training.AppConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ImportResource({ "classpath:beans.xml" })
@PropertySource(value = { "classpath:scan.properties" })
public class SpringTestConfiguration {
//    @Bean()
//    public AppConfig spelExample() {
//        AppConfig appConfig = new AppConfig();
//        appConfig.setMyStringProperty("0123456789");
//        return appConfig;
//    }
}
