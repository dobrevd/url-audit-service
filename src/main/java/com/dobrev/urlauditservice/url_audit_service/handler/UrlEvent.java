package com.dobrev.urlauditservice.url_audit_service.handler;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "url-events")
@Builder
@CompoundIndex(name = "user_id_timestamp_idx", def = "{'userId': 1, 'timestamp': 1}")
public record UrlEvent(
        @Id String eventId,
        @Indexed long userId,
        EventType eventType,
        String shortUrlHash,
        String originalUrl,
        @Indexed long timestamp
) {
}