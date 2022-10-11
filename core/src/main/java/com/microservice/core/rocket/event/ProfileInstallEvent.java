package com.microservice.core.rocket.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileInstallEvent {
    private Long timestamp;
    private String deviceName;
    private String iccid;
}
