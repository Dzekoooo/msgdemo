package com.wechat.msgdemo.service;

import com.wechat.msgdemo.entity.TextMsg;

/**
*@Author: ZhangZhe
*@Description
*@Date: 2018/1/15
*/
public interface TextMsgService {

    /**
     * 消息发送
     *
     * @param textMsg
     * @return
     */
    boolean textSendMsg(TextMsg textMsg);

    /**
     * 验证用户、部门、标签的输入格式
     *
     * @param info
     * @return
     */
    boolean regexCheck(String info);


}
