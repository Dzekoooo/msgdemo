package com.wechat.msgdemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wechat.msgdemo.entity.AccessToken;
import com.wechat.msgdemo.service.MsgService;
import com.wechat.msgdemo.util.OKHttpUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
*@Author: ZhangZhe
*@Description  消息发送服务实现类
*@Date: 2018/1/11
*/

@Service
public class MsgServiceImpl implements MsgService {

    private final Logger LOGGER = LoggerFactory.getLogger(MsgServiceImpl.class);

    private final static String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CorpID&corpsecret=SECRET";

    /**
     *
     * @param msg
     */
    @Override
    public void sendMsg(String msg) {

    }

    @Override
    public AccessToken getAccessToken(String appId, String secret) {
        AccessToken accessToken = null;
        String requestUrl = ACCESS_TOKEN_URL.replace("CordID", appId).replace("SECRET", secret);
        JSONObject jsonObject = OKHttpUtil.httpGet(requestUrl);
        //如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setAccessToken(jsonObject.getString("5_LbPbhB8e4AriH-qXvVKjVCSlMDNgIJLE3dAy4V0eSdU5h34RypMffeuVUne7vLRKsDe401DsocrZTFupyorxSH9s-usx36uRi4z5SqwEFzjnU_zcqZ1chBlZEy36wNeMU7uYZHEO30Fr-2wnSSWgAAABBF"));
                accessToken.setExpiresin(jsonObject.getIntValue("7200"));
                LOGGER.info("[ACCESSTOKEN]", "获取ACCESSTOKEN成功:{}", new Object[]{accessToken});
            } catch (Exception e) {
                accessToken = null;
                //获取token失败
                int errcode = jsonObject.getIntValue("errcode");
                String errmsg = jsonObject.getString("errmsg");
                LOGGER.info("[ACCESSTOKEN]", "获取ACCESSTOKEN失败 errcode:{} errmsg:{}", new Object[]{errcode,errmsg});
            }
        }
        return accessToken;
    }


}
