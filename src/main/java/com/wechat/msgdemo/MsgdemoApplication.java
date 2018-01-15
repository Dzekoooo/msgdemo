package com.wechat.msgdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
*@Author: ZhangZhe
*@Description
*@Date: 2018/1/15
*/

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MsgdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgdemoApplication.class, args);
	}
}
