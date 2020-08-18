package com.crazy.selfRibborRules;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * ribbon 的负载均衡策略配置包，必须放到componentScan 注解扫描不到的包下
 * 也就是不能和主启动类放在同一包下
 */
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();  //负载均衡策略为随机
    }
}
