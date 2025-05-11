package com.dobrev.urlauditservice.url_audit_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class UrlAuditServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlAuditServiceApplication.class, args);
	}

}
