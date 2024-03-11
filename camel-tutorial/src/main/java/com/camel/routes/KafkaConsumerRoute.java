package com.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
//public class KafkaConsumerRoute extends RouteBuilder {
//
//    @Override
//    public void configure() throws Exception {
//        from("kafka:test-topic?brokers=localhost:9092")
//                .log("Received message: ${body}");
//    }
//
//    @Override
//    public void configure() throws Exception {
//       from("file:/DEVELOPMENT/orders")
//               .to("kafka://orders?brokers=kafka:9092");
//
//       from("kafka://orders?brokers=kafka:9092")
//                .log("${body}")
//                .split(xpath("/orders/order"))
//                .choice()
//                .when(xpath("//order/type/text() = 'vegetables'"))
//                .to("activemq:queue:vegetable")
//                .when(xpath("//order/type/text() = 'fruits'"))
//                .to("activemq:queue:fruits")
//                .otherwise()
//                .to("kafka://product?brokers=kafka:9092");
//    }
//}
