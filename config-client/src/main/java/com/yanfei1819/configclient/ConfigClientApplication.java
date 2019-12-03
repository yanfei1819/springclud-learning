package com.yanfei1819.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 配置中心客户端
 *
 * 直接在配置文件中配置好配置中心服务端的相关信息，然后写一个程序入口，读取配置文件
 *
 * 过程：config-server 先从 GitHub 中读取信息，然后 config-client 从 config-server 中读取
 */
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}
