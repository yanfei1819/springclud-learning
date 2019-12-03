# 服务说明- eureka-server 服务注册中心- provider 服务提供者，对外提供接口- caller 服务调用者，该服务中测试了 ribbon+rest 和 feign 两种调用服务的方式- caller-ribbon-hystrix 测试 ribbon+rest 的熔断器- caller-feign-hystrix 测试 feign 的熔断器- hystrix-dashboard 熔断器监控- config-server 分布式配置中心服务端，读取git的配置信息- config-client 分布式配置中心客户端，读取分布式配置中心服务端的数据- zuul 路由网关- zipkin-server 服务链路追踪，服务端（此项目中没有用到，用的事 jar 包启动）- zipkin-a,zipkin-b 两个服务相互调用，演示【服务链路追踪】---SpringCloud 与 dubbo 对比： - SpringCloud    - 使用 HTTP，传输文本，效率较低    - 兼容性更强    - 面向现在- Double是 TCP      - 传输二进制，效率更高    - 兼容性更弱    - 面向未来