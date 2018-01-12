package com.wechat.msgdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wechat.msgdemo.entity.AccessToken;
import com.wechat.msgdemo.entity.Msg;
import com.wechat.msgdemo.service.MsgService;
import com.wechat.msgdemo.util.BaseUtil;
import com.wechat.msgdemo.util.GetAccessToken;
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

    private static Logger LOGGER = LoggerFactory.getLogger(MsgServiceImpl.class);

    private final static String SEND_MSG_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";

    /**
     *
     * @param msg
     */
    @Override
    public boolean sendMsg(Msg msg) {
        LOGGER.info("===========进入消息发送方法=======================");
        AccessToken accessToken = GetAccessToken.getAccessToken(BaseUtil.corpId, BaseUtil.secret);
        String token = JSON.toJSONString(accessToken);
        StringBuffer sb = new StringBuffer();
        boolean result = true;

        sb.append("{");
        sb.append("\"touser\":" + "\"" + msg.getTouser() + "\",");
        sb.append("\"toparty\":" + "\"" + msg.getTopatry() + "\",");
        sb.append("\"totag\":" + "\"" + msg.getTotag() + "\",");
        sb.append("\"msgtype\":" + "\"" + "text" + "\",");
        sb.append("\"agentid\":" + "\"" + "21" + "\",");
        sb.append("\"text\":" + "{");
        sb.append("\"content\":" + "\"" + msg.getContent() + "\"},");
        sb.append("\"debug\":" + "\"" + "1" + "\"");
        sb.append("}");

        String data = new String(sb);
        String url = SEND_MSG_URL.replace("ACCESS_TOKEN", token).replace(" ", "");
        JSONObject jsonObject = OKHttpUtil.httpPost(url, data);
        if (0 != (Integer)jsonObject.get("errcode")) {
            result = false;
            throw new RuntimeException("通知用户失败");
        }
        return result;


    }
}
