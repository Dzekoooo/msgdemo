package com.wechat.msgdemo.entity;

import java.io.Serializable;

/**
*@Author: ZhangZhe
*@Description       文本消息响应信息封装类
*@Date: 2018/1/12
*/
public class TextSendResponse implements Serializable {

    /**
     * 错误码
     */
    private Integer errCode;

    /**
     * 错误信息
     */
    private String errMsg;

    /**
     * 无效的用户
     */
    private String invalidUser;

    /**
     * 无效的部门
     */
    private String invalidParty;

    /**
     * 无效的标签
     */
    private String invalidTag;

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getInvalidUser() {
        return invalidUser;
    }

    public void setInvalidUser(String invalidUser) {
        this.invalidUser = invalidUser;
    }

    public String getInvalidParty() {
        return invalidParty;
    }

    public void setInvalidParty(String invalidParty) {
        this.invalidParty = invalidParty;
    }

    public String getInvalidTag() {
        return invalidTag;
    }

    public void setInvalidTag(String invalidTag) {
        this.invalidTag = invalidTag;
    }

    @Override
    public String toString() {
        return "TextSendResponse{" +
                "errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                ", invalidUser='" + invalidUser + '\'' +
                ", invalidParty='" + invalidParty + '\'' +
                ", invalidTag='" + invalidTag + '\'' +
                '}';
    }
}
