package com.yanfei1819.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 路由网关：功能是转发和过滤
 * zuul 和 ribbon 结合实现了负载均衡的功能
 *
 * 路由功能：只需要在application.properties 中配置，然后启动相关的服务
 * 服务过滤：创建实现 ZuulFilter 的类
 *
 */
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

}
