package com.microservice.core.event;

import lombok.Builder;
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
public class DownloadEvent extends ApplicationEvent {

    private String eid;

    private String iccid;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public DownloadEvent(Object source, String eid, String iccid) {
        super(source);
        this.eid = eid;
        this.iccid = iccid;
    }
}
