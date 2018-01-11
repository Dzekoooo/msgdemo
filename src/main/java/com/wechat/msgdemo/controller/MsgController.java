package com.wechat.msgdemo.controller;

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
public class MsgController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgController.class);

    @Autowired
    private MsgService msgService;

//    @RequestMapping("gettoken")


}
