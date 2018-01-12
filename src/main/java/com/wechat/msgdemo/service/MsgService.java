package com.wechat.msgdemo.service;

import com.wechat.msgdemo.entity.AccessToken;
import com.wechat.msgdemo.entity.Msg;

public interface MsgService {
    /**
     * 发送消息
     *
     * @param msg
     */
    boolean sendMsg(Msg msg);


}
