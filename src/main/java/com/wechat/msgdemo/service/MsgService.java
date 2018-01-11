package com.wechat.msgdemo.service;

import com.wechat.msgdemo.entity.AccessToken;

public interface MsgService {
    /**
     * 发送消息
     *
     * @param msg
     */
    void sendMsg(String msg);

    AccessToken getAccessToken(String appId, String secret);
}
