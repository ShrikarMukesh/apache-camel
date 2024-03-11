package com.camel.processors;

// Processor3.java
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.JSONObject;
import org.json.XML;

@Slf4j
public class Processor3 implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        // Processor 3 logic: Converting XML message to JSON
        log.info("Processor 3 is processing the message");
        // Retrieve the XML body from the exchange
        String xmlBody = exchange.getProperty("originalXmlBody", String.class);

        // Convert XML to JSON
        JSONObject json = XML.toJSONObject(xmlBody);

        // Set the JSON body to the exchange
        exchange.getIn().setBody(json.toString());
        String str =  exchange.getMessage().toString();
        log.info("Str" + str);
    }
}
