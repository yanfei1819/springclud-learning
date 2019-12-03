package com.yanfei1819.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 分布式配置中心：服务端
 * 在配置文件中配置好相关的路径，然后启动该项目。访问 http://localhost:8057/name/dev
 * 打印如下：
 *  {"name":"name","profiles":["dev"],"label":null,"version":"c80bfcf13f5d4f82579ddc9a8d7f819e5dd58574","state":null,"propertySources":[]}
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
