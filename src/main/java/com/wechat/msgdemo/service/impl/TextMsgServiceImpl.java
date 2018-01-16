package com.wechat.msgdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wechat.msgdemo.entity.AccessToken;
import com.wechat.msgdemo.entity.TextMsg;
import com.wechat.msgdemo.entity.TextSendResponse;
import com.wechat.msgdemo.service.TextMsgService;
import com.wechat.msgdemo.util.BaseUtil;
import com.wechat.msgdemo.util.GetAccessToken;
import com.wechat.msgdemo.util.OKHttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

/**
*@Author: ZhangZhe
*@Description  消息发送服务实现类
*@Date: 2018/1/11
*/

@Service
public class TextMsgServiceImpl implements TextMsgService {

    private static Logger LOGGER = LoggerFactory.getLogger(TextMsgServiceImpl.class);

    /**
     * 发送消息的接口地址
     */
    private static final String SEND_MSG_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";

    /**
     *
     * @param textMsg
     */
    @Override
    public boolean textSendMsg(TextMsg textMsg) {
        LOGGER.info("===========进入文本消息发送方法=======================");

        TextSendResponse tsr = new TextSendResponse();
        boolean result = true;
        AccessToken accessToken = GetAccessToken.getAccessToken(BaseUtil.corpId, BaseUtil.secret);
        StringBuffer sb = new StringBuffer();

        sb.append("{");
        sb.append("\"touser\":" + "\"" + textMsg.getToUser() + "\",");
        sb.append("\"toparty\":" + "\"" + textMsg.getToPatry() + "\",");
        sb.append("\"totag\":" + "\"" + textMsg.getToTag() + "\",");
        sb.append("\"msgtype\":" + "\"" + "text" + "\",");
        sb.append("\"agentid\":" + "\"" + textMsg.getAgentId() + "\",");
        sb.append("\"text\":" + "{");
        sb.append("\"content\":" + "\"" + textMsg.getContent() + "\"},");
        sb.append("\"safe\":" + "\"" + "0" + "\"");
        sb.append("}");

        String data = new String(sb);
        String url = SEND_MSG_URL.replace("ACCESS_TOKEN", accessToken.getAccessToken()).replace(" ", "");
        JSONObject jsonObject = OKHttpUtil.httpPost(url, data);

        if (null == jsonObject) {
            tsr.setErrCode(jsonObject.getIntValue("errcode"));
            tsr.setErrMsg(jsonObject.getString("errmsg"));
            tsr.setInvalidUser(jsonObject.getString("invaliduser"));
            tsr.setInvalidParty(jsonObject.getString("invalidparty"));
            tsr.setInvalidTag(jsonObject.getString("invalidtag"));
            String errStr = JSON.toJSONString(tsr);
            result = false;
            LOGGER.error(errStr);
        }
        return result;
    }

    /**
     * 正则表达是匹配输入用户格式
     *
     * @param info
     * @return
     */
    @Override
    public boolean regexCheck(String info) {
        String pattern = "(([a-zA-Z]{1,}[|]*)+([a-zA-Z]{1,})* )";
        boolean result = false;
        boolean isMatch = Pattern.matches(pattern, info);
        if (isMatch) {
            result = true;
        }
        return result;
    }
}
