package com.yanfei1819.busconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * SpringCloud bus 消息总线，本实例中用的消息中间件是 activemq
 *
 * TODO 未完待续
 */
@SpringBootApplication
public class BusConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusConfigClientApplication.class, args);
	}

}
