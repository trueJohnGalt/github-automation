package com.elysium.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.elysium")
@PropertySource({
        "classpath:/properties/${env}.properties",
        "classpath:/properties/common.properties"
})
public class SpringConfig {
}
