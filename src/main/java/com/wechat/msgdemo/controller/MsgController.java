package com.wechat.msgdemo.controller;

import com.wechat.msgdemo.entity.TextMsg;
import com.wechat.msgdemo.service.TextMsgService;
import com.wechat.msgdemo.util.CreateView;
import com.wechat.msgdemo.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
*@Author: ZhangZhe
*@Description
*@Date: 2018/1/11
*/

@Controller
@RequestMapping("/")
public class MsgController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgController.class);

    @Autowired
    private TextMsgService textMsgService;


    @RequestMapping("sendtext")
    public ModelAndView tokenMsg(ModelAndView mv, TextMsg textMsg) {
        LOGGER.info("===================进入sendmsg========================");
        boolean result = textMsgService.textSendMsg(textMsg);
        if (result != false) {
            mv = CreateView.createView(PageUtil.SUCCESS_TEXT, PageUtil.SUCCESS_PAGE);
            return mv;
        }
        mv = CreateView.createView(PageUtil.ERROR_TEXT, PageUtil.ERROR_PAGE);
        return  mv;
    }
}
