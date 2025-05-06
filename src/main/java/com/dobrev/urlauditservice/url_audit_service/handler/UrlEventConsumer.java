package com.dobrev.urlauditservice.url_audit_service.handler;

import com.dobrev.urlauditservice.url_audit_service.service.UrlAuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

@RequiredArgsConstructor
@KafkaListener(topics = "${audit.kafka.topic}")
@Slf4j
public class UrlEventConsumer {
    private final UrlAuditService urlAuditService;

    @KafkaHandler
    public void handleUrlEvent(UrlEvent event) {
        urlAuditService.save(event);
        log.info("Event with id: {} is processed ", event.eventId());
    }
}