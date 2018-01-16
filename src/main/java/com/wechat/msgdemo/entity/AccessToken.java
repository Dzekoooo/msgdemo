package com.wechat.msgdemo.entity;

import java.io.Serializable;

/**
*@Author: ZhangZhe
*@Description       AccessToken
*@Date: 2018/1/16
*/

public class AccessToken implements Serializable{

    /**
     * accessToken 连接密钥
     */
    private String accessToken;

    /**
     * accessToken 存在期限
     */
    private Integer expiresin;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresin() {
        return expiresin;
    }

    public void setExpiresin(Integer expiresin) {
        this.expiresin = expiresin;
    }

    @Override
    public String toString() {
        return "GetAccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresin=" + expiresin +
                '}';
    }
}
