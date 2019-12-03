package com.yanfei1819.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 * Spring Cloud提供了多种注册中心的支持，如：Eureka、consul、ZooKeeper等。Eureka已经闭源了。
 *
 * Eureka包含两个组件：Eureka Server和Eureka Client：
 * 1、Eureka Server提供服务注册服务，各个节点启动后，会在Eureka Server中进行注册，
 * 这样EurekaServer中的服务注册表中将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观的看到。
 *
 * 2、Eureka Client是一个java客户端，用于简化与Eureka Server的交互，客户端同时也就别一个内置的、
 * 使用轮询(round-robin)负载算法的负载均衡器。
 *
 * 3、在应用启动后，将会向Eureka Server发送心跳,默认周期为30秒，如果Eureka Server在多个心跳周期内没有
 * 接收到某个节点的心跳，Eureka Server将会从服务注册表中把这个服务节点移除(默认90秒)。
 *
 * 4、Eureka Server之间通过复制的方式完成数据的同步，Eureka还提供了客户端缓存机制，即使所有的Eureka Server都挂掉，
 * 客户端依然可以利用缓存中的信息消费其他服务的API。综上，Eureka通过心跳检查、客户端缓存等机制，确保了系统的高可用性、灵活性和可伸缩性。
 *
 * 注意：在正式的项目中，直接登录访问服务注册中心，其实是不安全的，所以，可以添加用户认证。
 * 步骤：
 * 1、添加依赖
 * 		<dependency>
 * 		    <groupId>org.springframework.boot</groupId>
 * 		    <artifactId>spring-boot-starter-security</artifactId>
 * 		</dependency>
 *
 * 2、添加配置
 * 		###服务端口号
 * 		server:
 * 		  port: 8100
 *
 * 		###服务名称
 * 		spring:
 * 		  application:
 * 		    name: app-eureka-center
 * 		  security:
 * 		    basic:
 * 		      enable: true #开启基于HTTP basic的认证
 * 		    user: #配置用户的账号信息
 * 		      name: zpc
 * 		      password: 123456
 *
 * 		eureka:
 * 		  instance:
 * 		    #注册中心地址
 * 		    hostname: 127.0.0.1
 *
 * 		###客户端调用地址
 * 		  client:
 * 		    serviceUrl:
 * 		      defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@${eureka.instance.hostname}:8100/eureka/
 * 		###是否将自己注册到Eureka服务中,因为该应用本身就是注册中心，不需要再注册自己（集群的时候为true）
 * 		    register-with-eureka: false
 * 		###是否从Eureka中获取注册信息,因为自己为注册中心,不会在该应用中的检索服务信息
 * 		    fetch-registry: true
 *
 * 3、添加安全认证类
 * 		package com.zpc.springcloud.eureka;
 *
 * 		import org.springframework.context.annotation.Configuration;
 * 		import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * 		import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 * 		import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 * 		import org.springframework.security.config.http.SessionCreationPolicy;
 *
 * 		@Configuration
 * 		@EnableWebSecurity
 * 		public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 *
 * 		    /*
 * 		     * 高版本springcloud的丢弃了配置:
 * 		     *
 * 		     * security:
 * 		     *   basic:
 * 		     *    enabled: true
 * 		     *
 * 		     * 所以应该使用以下方式开启
 * 		     *
 * 		     * @param http
 * 		     * @throws Exception
 * 		     *
 *				@Override
 *				protected void configure(HttpSecurity http)throws Exception{
 * 		        // Configure HttpSecurity as needed (e.g. enable http basic).
 *				http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
 *				http.csrf().disable();
 *				         //注意：为了可以使用 http://${user}:${password}@${host}:${port}/eureka/ 这种方式登录,所以必须是httpBasic,
 *				         // 如果是form方式,不能使用url格式登录
 *				http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
 *				}
 * 		}
 *
 * 4、此时，client端的服务注册到服务注册中心去时，配置信息需要改为（账户名和密码）：
 * 		http://USER:PASSWORD@127.0.0.1:端口号/eureka/
 *
 *
 *
 * 	eurekaserver的自我保护机制：
 * 	默认情况下，如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，Eureka Server将会从服务注册表中把这个服务节点移除(默认90秒)。
 * 	但是当网络分区发生故障时，client和server无法正常通信，以上行为就非常危险了——因为微服务本身是健康的，不应移出服务节点。
 *
 * 	eureka 通过自我保护机制来解决该问题：当段时间内丢失多个节（可能发生网络分区故障），那么这个几点就会进入自我保护模式，一旦进入该模式，
 * 	server 就会保护服务注册表中的信息，不会删除服务注册表中的数据，也不会移出任何节点。当网络故障恢复后，server 节点自动退出自我保护模式。
 * 	类比：“宁放过，莫杀错！”
 *
 * 	当然，如果你愿意，可以禁用自我保护模式：
 * 	  server:
 *       enable-self-preservation: false #禁用自我保护模式
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}

