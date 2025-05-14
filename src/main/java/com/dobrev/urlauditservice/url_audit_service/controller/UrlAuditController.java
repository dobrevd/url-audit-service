package com.dobrev.urlauditservice.url_audit_service.controller;

import com.dobrev.urlauditservice.url_audit_service.handler.UrlEvent;
import com.dobrev.urlauditservice.url_audit_service.service.UrlAuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/audit")
@RequiredArgsConstructor
public class UrlAuditController {
    private final UrlAuditService urlAuditService;

    @PostMapping
    public UrlEvent saveEvent(@RequestBody UrlEvent urlEvent) {
        return urlAuditService.save(urlEvent);
    }

    @GetMapping
    public Page<UrlEvent> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return urlAuditService.findAll(pageable);
    }
}