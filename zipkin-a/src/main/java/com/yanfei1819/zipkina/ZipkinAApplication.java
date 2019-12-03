package com.yanfei1819.zipkina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * 测试服务链路追踪，与zipkin-b 相互调用
 *
 * 然后在 zipkin-server 的界面（http://localhost:9411/zipkin）可以看到相互调用的信息链
 * 注意：在本演示中， zipkin-server 是直接下载jar包启动的，没有利用的 一下创建的 zipkin-server 微服务
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class ZipkinAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinAApplication.class, args);
	}

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
