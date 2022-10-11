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
        selectorExpression = RocketTag.PROFILE_INSTALL + "||" + RocketTag.DEVICE_INFO)
public class DeviceInstallProfileHandler implements RocketMQListener<MqMessage> {

    @Override
    public void onMessage(MqMessage message) {
        if (RocketTag.DEVICE_INFO.equals(message.getTag())) {
            log.info("【设备模块】收到消息 ：[{}], 新增一条设备信息", message);
        } else {
            log.info("【设备模块】收到消息 ：[{}], 更新设备安装码号信息", message);
        }
    }
}
