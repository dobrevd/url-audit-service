package com.dobrev.urlauditservice.url_audit_service.handler;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "url-events")
@Builder
public record UrlEvent(
         @Id
         String eventId,
         long userId,
         EventType eventType,
         String shortUrlHash,
         String originalUrl,
         Instant timestamp
) {}