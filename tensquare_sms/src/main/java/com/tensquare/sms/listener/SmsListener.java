package com.tensquare.sms.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author tank
 * @create 2019/01/18 15:28
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @RabbitHandler
    public void executeSms(Map<String, Map> map) {
        System.out.println("手机号"+map.get("mobile"));
        System.out.println("验证码"+map.get("checkcode"));
    }

    //阿里云发短信
    //阿里短信服务拒绝个人申请，该功能作罢
}

