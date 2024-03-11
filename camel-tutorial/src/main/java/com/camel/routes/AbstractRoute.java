package com.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
//public class AbstractRoute  extends RouteBuilder{
//
//    @Value("${kafka.topic.name}")
//    private String kafkaTopic;
//
//    @Value("${camel.route.kafkaProducer}")
//    private String kafkaProducerRoute;
//
//    @Value("${camel.route.kafkaConsumer}")
//    private String kafkaConsumerRoute;
//
//    @Override
//    public void configure() throws Exception {
//        // Kafka producer route
//        from("direct:" + kafkaProducerRoute)
//                .to("kafka:" + kafkaTopic);
//
//        // Kafka consumer route
//        from("kafka:" + kafkaTopic)
//                .routeId(kafkaConsumerRoute)
//                .log("Received message from Kafka: ${body}");
//    }
//}
