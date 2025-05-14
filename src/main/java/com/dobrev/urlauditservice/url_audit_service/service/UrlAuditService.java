package com.dobrev.urlauditservice.url_audit_service.service;

import com.dobrev.urlauditservice.url_audit_service.handler.UrlEvent;
import com.dobrev.urlauditservice.url_audit_service.repository.UrlEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Page<UrlEvent> findAll(Pageable pageable) {
        var all = urlEventRepository.findAll(pageable);
        log.info("All events are found");

        return all;
    }
}
