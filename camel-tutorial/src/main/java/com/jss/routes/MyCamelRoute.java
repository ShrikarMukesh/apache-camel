package com.jss.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class MyCamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:src/main/resources?noop=true&include=.*\\.xml")
                .log("Received XML file: ${file:name}")
                .to("direct:processXml");
    }
}
