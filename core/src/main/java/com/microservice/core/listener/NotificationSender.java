package com.microservice.core.listener;

import com.microservice.core.event.NotifyEvent;
import com.microservice.core.repo.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;

/**
 * @author Alex Liu
 * @date 2021/12/20
 */
@Configuration
@Slf4j
public class NotificationSender {

    @Autowired
    private DeviceRepository deviceRepository;

    @PostConstruct
    private void init() {
        log.info(deviceRepository.findAll().toString());
    }

    @EventListener(NotifyEvent.class)
    //@Async
    @Order(3)
    public void listenNotification(ApplicationEvent event) {
        NotifyEvent notifyEvent = (NotifyEvent) event;
        log.info("NotificationSender get notify event [{}]", notifyEvent);
        log.info("send http notify to MNO, iccid [{}] is [{}]", notifyEvent.getIccid(), notifyEvent.getNotificationType());
    }
}
