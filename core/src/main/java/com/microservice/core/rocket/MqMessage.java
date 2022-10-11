package com.microservice.core.rocket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MqMessage {

    private Object message;

    private String topic;

    private String tag;

    private String key;
}
