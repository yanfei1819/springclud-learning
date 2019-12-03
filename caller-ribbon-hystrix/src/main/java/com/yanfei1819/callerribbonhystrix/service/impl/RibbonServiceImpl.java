package com.yanfei1819.callerribbonhystrix.service.impl;import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;import com.yanfei1819.callerribbonhystrix.service.RibbonService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.springframework.web.client.RestTemplate;/** * Created by 追梦1819 on 2019-03-27. */@Servicepublic class RibbonServiceImpl implements RibbonService {    // 将restTemplate注入    @Autowired    private RestTemplate restTemplate;    // 由微服务caller-ribbon-hystrix改造而来    // 模拟时，只要把提供者服务关闭    @Override    @HystrixCommand(fallbackMethod="helloError")    public String sayHello() {        return restTemplate.getForObject("http://provider/hello",String.class);    }    public String helloError(){        return "error";    }}