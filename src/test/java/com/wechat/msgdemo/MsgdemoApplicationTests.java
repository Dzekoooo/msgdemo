package com.wechat.msgdemo;

import com.alibaba.fastjson.JSON;
import com.wechat.msgdemo.entity.AccessToken;
import com.wechat.msgdemo.util.BaseUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.wechat.msgdemo.util.GetAccessToken.getAccessToken;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsgdemoApplicationTests {

	@Test
	public void TokenTest(){
		try {
			AccessToken accessToken = getAccessToken(BaseUtil.corpId, BaseUtil.secret);
			System.out.println(JSON.toJSONString(accessToken));
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void MsgTest() {
//		Msg msg = new Msg();
//		msg.setAgentid(1);
//		msg.setContent("helloworld");
//		msg.setMsgtype("text");
//		String ss = msg.toString();
//		String s = JSON.toJSONString(msg);
//		System.out.println("s = " + s);
//		System.out.println("ss = " + ss);
		int openid = 1;
		String content = "helloworld";
		String data = "{"+
				"\"touser\":\""+openid+"\","+
				"\"msgtype\":\"text\","+
				"\"text\":"+
				"{"+
				"\"content\":\""+content+"\""+
				"}"+
				"}";
		System.out.println("data = " + data);
	}

}
