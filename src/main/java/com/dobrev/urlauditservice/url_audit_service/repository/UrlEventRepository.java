package com.dobrev.urlauditservice.url_audit_service.repository;

import com.dobrev.urlauditservice.url_audit_service.handler.EventType;
import com.dobrev.urlauditservice.url_audit_service.handler.UrlEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlEventRepository extends MongoRepository<UrlEvent, String> {
    List<UrlEvent> findByUserIdAndTimestampBetweenAndEventType(long userId, long startOfDay, long endOfDay, EventType eventType);
}