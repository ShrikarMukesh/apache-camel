package com.camel.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "camel.component.kafka")
public class KafkaProperties {
//
//    @Value("${brokers}")
//    private String brokers;
//
//    @Value("${groupId}")
//    private String groupId;
//
//    @Value("${autoOffsetReset}")
//    private String autoOffsetReset;
//
//    @Value("${keyDeserializer}")
//    private String keyDeserializer;
//
//    @Value("${valueDeserializer}")
//    private String valueDeserializer;

}
