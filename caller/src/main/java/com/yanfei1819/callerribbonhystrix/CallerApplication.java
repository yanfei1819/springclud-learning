package com.yanfei1819.callerribbonhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务调用方
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // 该注解开启feign功能
public class CallerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallerApplication.class, args);
	}


	// 通过ribbon+rest调用的方式需要
	// 将RestTemplate纳入Spring容器进行管理
	// @LoadBalanced的作用是在请求客户有负载均衡的能力
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
