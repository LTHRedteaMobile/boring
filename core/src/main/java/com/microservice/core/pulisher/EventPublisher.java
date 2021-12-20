package com.microservice.core.pulisher;

import com.microservice.core.event.DownloadEvent;
import com.microservice.core.event.NotifyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author Alex Liu
 * @date 2021/12/20
 */
@Component
public class EventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishDownloadEvent(String eid, String iccid) {
        applicationEventPublisher.publishEvent(new DownloadEvent(this, eid, iccid));
    }

    public void publishNotifyEvent(String notificationType, String iccid) {
        applicationEventPublisher.publishEvent(new NotifyEvent(this, notificationType, iccid));
    }
}
