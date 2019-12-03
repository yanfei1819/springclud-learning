package com.yanfei1819.callerribbonhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 演示feign的熔断器，只要将provider微服务关掉既可看到效果。
 *
 * hystrix 具备服务降级、服务熔断、线程和信号隔离、请求缓存、请求合并以及服务监控
 *
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // 该注解开启feign功能
@EnableHystrix
public class CallerFeignHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallerFeignHystrixApplication.class, args);
	}

}
