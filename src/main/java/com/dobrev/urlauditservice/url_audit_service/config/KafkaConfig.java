package com.dobrev.urlauditservice.url_audit_service.config;

import com.dobrev.urlauditservice.url_audit_service.handler.UrlEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {
    private final Environment environment;

    Map<String, Object> consumerConfigs() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                environment.getProperty("spring.kafka.bootstrap-servers"));
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "url-events-consumer");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return config;
    }

    @Bean
    public ConsumerFactory<String, UrlEvent> consumerFactory() {
        JsonDeserializer<UrlEvent> deserializer = new JsonDeserializer<>(UrlEvent.class);
        deserializer.addTrustedPackages("com.dobrev.urlauditservice.url_audit_service.handler");
        deserializer.setRemoveTypeHeaders(false);
        deserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(
                consumerConfigs(),
                new StringDeserializer(),
                new ErrorHandlingDeserializer<>(deserializer)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UrlEvent> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UrlEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}