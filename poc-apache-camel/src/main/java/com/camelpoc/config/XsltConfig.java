package com.camelpoc.config;

import javax.xml.transform.TransformerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XsltConfig {

    @Bean
    public TransformerFactory transformerFactory() {
        return TransformerFactory.newInstance();
    }
}
