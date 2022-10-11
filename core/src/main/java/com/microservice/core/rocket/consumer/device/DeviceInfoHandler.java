/*
package com.microservice.core.rocket.consumer.device;

import com.microservice.core.rocket.MqMessage;
import com.microservice.core.rocket.constant.RocketTag;
import com.microservice.core.rocket.constant.RocketTopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(topic = RocketTopic.CORE_TOPIC, consumerGroup = "Device_Service_Group",
        selectorExpression = RocketTag.DEVICE_INFO)
public class DeviceInfoHandler implements RocketMQListener<MqMessage> {

    @Override
    public void onMessage(MqMessage message) {
        log.info("【设备模块】收到消息 ：[{}], 新增一条设备信息", message);
    }
}
*/
