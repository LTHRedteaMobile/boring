package com.microservice.core.rocket.consumer.statistics;

import com.microservice.core.rocket.MqMessage;
import com.microservice.core.rocket.constant.RocketTag;
import com.microservice.core.rocket.constant.RocketTopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(topic = RocketTopic.CORE_TOPIC, consumerGroup = "Statistics_Service_Group",
        selectorExpression = RocketTag.PROFILE_INSTALL)
public class InstallRecordHandler implements RocketMQListener<MqMessage> {

    @Override
    public void onMessage(MqMessage message) {
        log.info("【统计模块】收到消息 ：[{}], 新增一条码号安装记录", message);
    }
}
