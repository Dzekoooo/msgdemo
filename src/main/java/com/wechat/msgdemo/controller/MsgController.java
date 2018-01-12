package com.wechat.msgdemo.controller;

import com.wechat.msgdemo.entity.Msg;
import com.wechat.msgdemo.service.MsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*@Author: ZhangZhe
*@Description
*@Date: 2018/1/11
*/

@Controller
@RequestMapping("/")
public class MsgController {

    @Autowired
    private MsgService msgService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgController.class);

    @RequestMapping("sendmsg")
    public void tokenMsg() {
        LOGGER.info("===================进入gettoken========================");
        Msg msg = new Msg();
        msg.setTotag("1");
        msg.setTopatry("2");
        msg.setTouser("1");
        msg.setContent("helloworld");
        boolean result = msgService.sendMsg(msg);
        System.out.println("result = " + result);
    }
}
