package com.microservice.core.rocket.producer;

import com.microservice.core.rocket.MqMessage;
import com.microservice.core.rocket.SendRocketMessage;
import com.microservice.core.rocket.constant.RocketTag;
import com.microservice.core.rocket.constant.RocketTopic;
import com.microservice.core.rocket.event.DeviceReportEvent;
import com.microservice.core.rocket.event.ProfileInstallEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CoreProducer {

    @Autowired
    private SendRocketMessage sendRocketMessage;

    public void sendProfileInstallMessage() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        ProfileInstallEvent event = ProfileInstallEvent.builder()
                .deviceName(uuid).timestamp(System.currentTimeMillis()).iccid("89765" + System.currentTimeMillis())
                .build();
        MqMessage message = MqMessage.builder()
                .key(uuid).message(event).tag(RocketTag.PROFILE_INSTALL).topic(RocketTopic.CORE_TOPIC)
                .build();
        sendRocketMessage.sendMessage(message);
    }

    public void sendDeviceReportMessage() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        DeviceReportEvent event = DeviceReportEvent.builder()
                .deviceName(uuid).timestamp(System.currentTimeMillis())
                .build();
        MqMessage message = MqMessage.builder()
                .key(uuid).message(event).tag(RocketTag.DEVICE_INFO).topic(RocketTopic.CORE_TOPIC)
                .build();
        sendRocketMessage.sendMessage(message);
    }
}
