package com.wechat.msgdemo.util;

import com.alibaba.fastjson.JSONObject;
import com.wechat.msgdemo.entity.AccessToken;
import com.wechat.msgdemo.entity.TextSendResponse;
import com.wechat.msgdemo.service.impl.TextMsgServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*@Author: ZhangZhe
*@Description 获取ACCESS_TOKEN工具类
*@Date: 2018/1/12
*/
public class GetAccessToken {

    // TODO: 2018/1/16 : 将AccessToken存放在数据库中，每两小时获取一次,需要的时候直接从数据库中取，提高性能

    private static final Logger LOGGER = LoggerFactory.getLogger(TextMsgServiceImpl.class);

    private static final String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRECT";

    public static AccessToken getAccessToken(String corpId, String secret) {
        AccessToken accessToken = null;
        String requestUrl = ACCESS_TOKEN_URL.replace("ID", corpId).replace("SECRECT", secret).replace(" ","");
        JSONObject jsonObject = OKHttpUtil.httpGet(requestUrl);
        //如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new com.wechat.msgdemo.entity.AccessToken();
                accessToken.setAccessToken(jsonObject.getString("access_token"));
                accessToken.setExpiresin(jsonObject.getIntValue("expires_in"));
                LOGGER.info("获取ACCESSTOKEN成功:{}", new Object[]{accessToken});
            } catch (Exception e) {
                accessToken = null;
                //获取token失败
                TextSendResponse tsr = new TextSendResponse();
                tsr.setErrCode(jsonObject.getIntValue("errcode"));
                tsr.setErrMsg(jsonObject.getString("errmsg"));
                LOGGER.error("获取ACCESSTOKEN失败:{}", new Object[]{tsr});
            }
        }
        return accessToken;
    }
}
