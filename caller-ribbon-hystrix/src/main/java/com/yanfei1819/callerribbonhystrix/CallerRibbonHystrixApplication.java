package com.yanfei1819.callerribbonhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务调用方，调用方式是ribbon方式。
 *
 * 模拟服务降级
 */
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
public class CallerRibbonHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallerRibbonHystrixApplication.class, args);
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
