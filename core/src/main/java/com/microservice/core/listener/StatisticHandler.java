package com.microservice.core.listener;

import com.microservice.core.event.DownloadEvent;
import com.microservice.core.event.NotifyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @author Alex Liu
 * @date 2021/12/20
 */
@Configuration
@Slf4j
public class StatisticHandler {

    @EventListener(DownloadEvent.class)
    @Async
    public void listenDownload(ApplicationEvent event) {
        DownloadEvent downloadEvent = (DownloadEvent) event;
        log.info("StatisticHandler get download event [{}]", downloadEvent);
        log.info("eid [{}] download time + 1, iccid = [{}]", downloadEvent.getEid(), downloadEvent.getIccid());
    }

    @EventListener(NotifyEvent.class)
    //@Async
    @Order(2)
    public void listenNotification(ApplicationEvent event) {
        NotifyEvent notifyEvent = (NotifyEvent) event;
        log.info("StatisticHandler get notify event [{}]", notifyEvent);
        log.info("change iccid [{}] status to [{}]", notifyEvent.getIccid(), notifyEvent.getNotificationType());
    }
}
