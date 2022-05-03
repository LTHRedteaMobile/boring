package com.microservice.core.controller;

import com.microservice.core.pulisher.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex Liu
 * @date 2022/05/03
 */
@RestController
@RequestMapping("/api/v1/core/event")
public class EventController {

    @Autowired
    private EventPublisher eventPublisher;

    @PostMapping("/publishDownload")
    public ResponseEntity publishDownload() {
        eventPublisher.publishDownloadEvent("EID1", "ICCID1");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/publishNotification")
    public ResponseEntity publishNotification() {
        eventPublisher.publishNotifyEvent("ENABLE", "ICCID1");
        return ResponseEntity.ok().build();
    }
}
