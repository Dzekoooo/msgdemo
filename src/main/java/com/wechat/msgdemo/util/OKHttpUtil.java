package com.wechat.msgdemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

/**
*@Author: ZhangZhe
*@Description  利用okhttp进行get和post访问
*@Date: 2018/1/11
*/
public class OKHttpUtil {

    /**
     * 发起get请求
     *
     * @param url
     * @return
     */
    public static JSONObject httpGet(String url) {
        String result = null;
        OkHttpClient client = new OkHttpClient();
        JSONObject jsonObject = new JSONObject();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
            jsonObject = JSON.parseObject(result);
        } catch (Exception e) {
            throw new RuntimeException("httpGet失败");
        }
        return jsonObject;
    }

    /**
     * 发送httppost请求
     *
     * @param url
     * @param data      提交的参数为key=value&key1=value1的形式
     * @return
     */
    public static JSONObject httpPost(String url, String data) {
        String result = null;
        OkHttpClient httpClient = new OkHttpClient();
        JSONObject jsonObject = new JSONObject();
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/html;charset=utf-8"), data);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try {
            Response response = httpClient.newCall(request).execute();
            result = response.body().string();
            jsonObject = JSON.parseObject(result);

        } catch (Exception e) {
            throw new RuntimeException("httpPost失败");
        }
        return jsonObject;
    }
}
