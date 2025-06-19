package com.dobrev.urlauditservice.url_audit_service.controller;

import com.dobrev.urlauditservice.url_audit_service.handler.UrlEvent;
import com.dobrev.urlauditservice.url_audit_service.service.UrlAuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/audit")
@RequiredArgsConstructor
public class UrlAuditController {
    private final UrlAuditService urlAuditService;

    @PostMapping
    public List<UrlEvent> saveEvents(@RequestBody List<UrlEvent> urlEvent) {
        return urlAuditService.saveAllEvents(urlEvent);
    }

    @GetMapping
    public Page<UrlEvent> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return urlAuditService.findAll(pageable);
    }

    @GetMapping("/user/{userId}/events")
    public List<UrlEvent> findAllResolveEventByUserIdAndDate(@PathVariable long userId,
                                                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return urlAuditService.findAllResolveEventByUserIdAndDate(userId, date);
    }
}