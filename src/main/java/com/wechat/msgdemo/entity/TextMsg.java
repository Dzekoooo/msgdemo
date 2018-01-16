package com.wechat.msgdemo.entity;

import java.io.Serializable;

/**
*@Author: ZhangZhe
*@Description       文本消息类
*@Date: 2018/1/15
*/
public class TextMsg implements Serializable{
    /**
     * 成员ID
     */
    private String toUser;

    /**
     * 部门ID
     */
    private String toPatry;

    /**
     * 标签ID
     */
    private String toTag;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 应用ID
     */
    private String agentId;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getToPatry() {
        return toPatry;
    }

    public void setToPatry(String toPatry) {
        this.toPatry = toPatry;
    }

    public String getToTag() {
        return toTag;
    }

    public void setToTag(String toTag) {
        this.toTag = toTag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextMsg{" +
                "toUser='" + toUser + '\'' +
                ", toPatry='" + toPatry + '\'' +
                ", toTag='" + toTag + '\'' +
                ", content='" + content + '\'' +
                ", agentId='" + agentId + '\'' +
                '}';
    }
}
