package com.crazy.openFeign.config;



import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfig {


    /**
     * openfeign 的日志级别有四种，
     * 1. NONE 默认的，不显示任何日志
     * 2. BASIC 仅仅记录请求方法的url ,响应状态码及执行时间
     * 3. HEADERS 除了basic中定义的信息外，还有请求和响应的头信息
     * 4。 FULL 除了HEADERS中 定义的信息外，还有请求和响应的正文及元数据
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
