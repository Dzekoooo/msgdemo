package com.wechat.msgdemo;

import com.wechat.msgdemo.entity.AccessToken;
import com.wechat.msgdemo.util.BaseUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Pattern;

import static com.wechat.msgdemo.util.GetAccessToken.getAccessToken;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsgdemoApplicationTests {

//	@Test
//	public void TokenTest(){
//		try {
//			AccessToken accessToken = getAccessToken(BaseUtil.corpId, BaseUtil.secret);
//			System.out.println("accessToken = " + accessToken.getAccessToken());
//		} catch (Exception e){
//			e.printStackTrace();
//		}
//	}

//	@Test
//	public void regexCheck(String info) {
//		String str = "[a-zA-Z]| + "+" ";
//		String pattern = "aaa|bbb|ccc";
//		boolean result = false;
//		boolean isMatch = Pattern.matches(str, info);
//		if (isMatch) {
//			System.out.println("aaa");
//		}
//		System.out.println("bbb");
//	}





	@Test
	public void MsgTest() {
//		TextMsg msg = new TextMsg();
//		msg.setAgentid(1);
//		msg.setContent("helloworld");
//		msg.setMsgtype("text");
//		String ss = msg.toString();
//		String s = JSON.toJSONString(msg);
//		System.out.println("s = " + s);
//		System.out.println("ss = " + ss);
		int openid = 1;
		String content = "这是一条测试的消息";
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
