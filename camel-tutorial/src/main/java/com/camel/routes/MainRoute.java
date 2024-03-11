package com.camel.routes;

import com.camel.config.KafkaProperties;
import com.camel.processors.Processor1;
import com.camel.processors.Processor2;
import com.camel.processors.Processor3;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainRoute extends RouteBuilder {

    private final KafkaProperties kafkaProperties;

    @Autowired
    public MainRoute(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }
//    @Override
//    public void configure() throws Exception {
//        from("kafka:test-topic?brokers=localhost:9092")
//                .log("Received message: ${body}");
//    }
    @Override
    public void configure() throws Exception {
        from("kafka:test-topic?brokers=localhost:9092")
                .process(new Processor1())
                .process(new Processor2())
                .process(new Processor3())
                .to("mock:result");
    }

}

