package com.microservice.core.rocket;

import com.microservice.core.modle.entity.Device;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendRocketMessage {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Async
    public void sendMessage(MqMessage mqMessage) {
        String topic = mqMessage.getTopic() + ":" + mqMessage.getTag();
        Message message = MessageBuilder
                .withPayload(mqMessage).setHeader("KEYS",mqMessage.getKey())
                .build();
        SendResult sendResult = rocketMQTemplate.syncSend(topic, message);
        log.info("sendResult = [{}]", sendResult);
    }
}
