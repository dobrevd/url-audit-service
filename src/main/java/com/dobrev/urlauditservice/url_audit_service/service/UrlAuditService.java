package com.dobrev.urlauditservice.url_audit_service.service;

import com.dobrev.urlauditservice.url_audit_service.handler.UrlEvent;
import com.dobrev.urlauditservice.url_audit_service.repository.UrlEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UrlAuditService {
    private final UrlEventRepository urlEventRepository;

    public UrlEvent save(UrlEvent event) {
        var savedEvent = urlEventRepository.save(event);
        log.info("Event with id: {} is saved ", event.eventId());

        return savedEvent;
    }

    public List<UrlEvent> findAll() {
        var all = urlEventRepository.findAll();
        log.info("All events are found");

        return all;
    }
}
