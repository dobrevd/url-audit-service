package com.dobrev.urlauditservice.url_audit_service.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class UrlEventDeserializer extends JsonDeserializer<UrlEvent> {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public UrlEvent deserialize(String topic, byte[] data) {
        try {
            return mapper.readValue(data, UrlEvent.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize UrlEvent. Topic: " + topic, e);
        }
    }
}
