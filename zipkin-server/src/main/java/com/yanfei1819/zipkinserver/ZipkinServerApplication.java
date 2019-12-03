package com.yanfei1819.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;


/**
 * zipkin-server：该服务的作用是收集调用数据
 * 在spring Cloud为F版本的时候，已经不需要自己构建Zipkin Server了，只需要下载jar即可
 * 下载地址：https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/
 *
 * 本演示项目中，是直接搭建的zipkin-server服务。
 * 注意：1.在引入 zipkin-server 的jar的maven配置文件时，需要加入版本信息，否则无法引入。原因待考究。
 *       <dependency>
 *            <groupId>io.zipkin.java</groupId>
 *            <artifactId>zipkin-server</artifactId>
 *            <version>2.12.4</version>
 *       </dependency>
 *
 *      2.zipkin的界面访问地址的端口号不是服务配置的端口号，而是 8080，即界面地址是：http://localhost:8080/zipkin/
 *
 *      TODO：后面重试，又访问不了，待解决。
 *
 * 以下载jar包的形式：
 * 1.下载地址同上，启动jar包；
 * 2.访问地址是： http://localhost:9411/zipkin/
 *
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ZipkinServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

}
