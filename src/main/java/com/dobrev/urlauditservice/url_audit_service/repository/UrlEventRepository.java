package com.dobrev.urlauditservice.url_audit_service.repository;

import com.dobrev.urlauditservice.url_audit_service.handler.UrlEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlEventRepository extends MongoRepository<UrlEvent, String> {
}