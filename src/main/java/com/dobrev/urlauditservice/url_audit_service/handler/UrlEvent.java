package com.dobrev.urlauditservice.url_audit_service.handler;

import lombok.Builder;

import java.time.Instant;

@Builder
public record UrlEvent(
         String eventId,
         long userId,
         EventType eventType,
         String shortUrlHash,
         String originalUrl,
         Instant timestamp
) {}