package com.camelpoc;

import org.apache.camel.builder.RouteBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PocApacheCamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApacheCamelApplication.class, args);
	}

//	@Bean
//    public RouteBuilder myRouteBuilder() {
//		return new RouteBuilder() {
//			@Override
//			public void configure() throws Exception {
//				// Kafka consumer route
//				from("kafka:my-topic?brokers=localhost:9092")
//						.errorHandler(
//								deadLetterChannel("direct:errorQueue1").maximumRedeliveries(3).redeliveryDelay(5000)
//						)
//						.to("direct:processMessage1");
//
//				// Route for retrying messages - Retry route 1
//				from("direct:errorQueue1")
//						.log("Retrying to process the message for the first time")
//						.to("direct:processMessage1");
//
//				// Kafka consumer route for another topic
//				from("kafka:another-topic?brokers=localhost:9092")
//						.errorHandler(
//								deadLetterChannel("direct:errorQueue2").maximumRedeliveries(5).redeliveryDelay(10000)
//						)
//						.to("direct:processMessage2");
//
//				// Route for retrying messages - Retry route 2
//				from("direct:errorQueue2")
//						.log("Retrying to process the message for the second time")
//						.to("direct:processMessage2");
//
//				// Abstract route for processing messages - Example
//				from("direct:processMessage1")
//						.log("Processing message 1: ${body}");
//
//				// Abstract route for processing messages - Example
//				from("direct:processMessage2")
//						.log("Processing message 2: ${body}");
//			}
//		};
//	}

}
