package com.wechat.msgdemo.entity;

public class AccessToken {

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
