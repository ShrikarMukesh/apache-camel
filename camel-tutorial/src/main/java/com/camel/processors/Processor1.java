package com.camel.processors;


import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
public class Processor1 implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        // Processor 1 logic: Retrieving XML message from Kafka
       log.info("Processor 1 is processing the message");
        // Assuming the message body is XML
        String xmlBody = exchange.getIn().getBody(String.class);
        log.info("XML Body: " + xmlBody);
        exchange.setProperty("originalXmlBody", xmlBody); // Store the original XML body if needed
    }
}
