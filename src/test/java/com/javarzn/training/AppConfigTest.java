package com.javarzn.training;

import com.javarzn.training.config.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AppConfigTest extends AbstractTest {
    /**
     * Обратим внимание на DI.
     *
     * В нашем примере существует более одного бина с типом AppConfig,
     * поэтому без дополнительной аннотации @Qualifier("spelExample")
     * и указания конкретного идентификатора (id или name) DI работать
     * не будет.
     */
    @Autowired
    @Qualifier("spelExample")
    private AppConfig properties;

    @Test
    public void testSomeMethod() {
        assertNotNull(properties.getMyStringProperty());
        // при создания бина через @Bean в SpringTestConfiguration
        // assertEquals("0123456789", properties.getMyStringProperty());
    }
}