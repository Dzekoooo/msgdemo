package com.wechat.msgdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*@Author: ZhangZhe
*@Description       选择消息类型跳转
*@Date: 2018/1/15
*/
@Controller
public class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    /**
     * 实现基本页面跳转
     *
     * @param page
     * @return
     */
    @RequestMapping("/to/{page}")
    public String page(@PathVariable("page") String page) {
        LOGGER.info("==============请求的页面是：= " + page);
        return page;
    }
}
