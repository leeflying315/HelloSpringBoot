package com.lifei.spring.example.demo.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
// 用来指定properties配置文件中的key前缀
// 对于application类无用
//@ConfigurationProperties(prefix = "server")
// 指定配置文件的位置
//@PropertySource("classpath:application-prod.yml")
public class ConfigProperties {
    @Value("${server.name}")
    private String kafkaServer;

    public String getKafkaServer() {
        return kafkaServer;
    }

    public void setKafkaServer(String kafkaServer) {
        this.kafkaServer = kafkaServer;
    }
}
