package com.dobrev.urlauditservice.url_audit_service.controller;

import com.dobrev.urlauditservice.url_audit_service.handler.UrlEvent;
import com.dobrev.urlauditservice.url_audit_service.service.UrlAuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<UrlEvent> findAll() {
        return urlAuditService.findAll();
    }
}
