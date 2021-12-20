package com.microservice.core.event;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author Alex Liu
 * @date 2021/12/20
 */
@Getter
@Setter
@ToString
public class NotifyEvent extends ApplicationEvent {

    private String notificationType;

    private String iccid;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public NotifyEvent(Object source, String notificationType, String iccid) {
        super(source);
        this.notificationType = notificationType;
        this.iccid = iccid;
    }
}
