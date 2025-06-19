package com.dobrev.urlauditservice.url_audit_service.service;

import com.dobrev.urlauditservice.url_audit_service.handler.EventType;
import com.dobrev.urlauditservice.url_audit_service.handler.UrlEvent;
import com.dobrev.urlauditservice.url_audit_service.repository.UrlEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UrlAuditService {
    private final UrlEventRepository urlEventRepository;

    public void save(UrlEvent event) {
        urlEventRepository.save(event);
        log.info("Event with id: {} is saved ", event.eventId());
    }

    public List<UrlEvent> saveAllEvents(List<UrlEvent> event) {
        var savedEvent = urlEventRepository.saveAll(event);
        log.info("Events are saved");
        return savedEvent;
    }

    public Page<UrlEvent> findAll(Pageable pageable) {
        var all = urlEventRepository.findAll(pageable);
        log.info("All events are found");

        return all;
    }

    public List<UrlEvent> findAllResolveEventByUserIdAndDate(long userId, LocalDate date) {
        long startOfDay = date.atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        long endOfDay = date.plusDays(1)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli() - 1;

        return urlEventRepository.findByUserIdAndTimestampBetweenAndEventType(userId, startOfDay, endOfDay, EventType.RESOLVE);
    }
}
