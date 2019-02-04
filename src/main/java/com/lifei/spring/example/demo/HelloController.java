package com.lifei.spring.example.demo;

import com.lifei.spring.example.demo.conf.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.LongAdder;

@RestController
public class HelloController {

    private static final String template = "Hello, %s!";
    private final LongAdder counter = new LongAdder();

    @Autowired
    ConfigProperties configProperties;

    @RequestMapping("/hello")
    public String index(@RequestParam(value="name", defaultValue="World")String name){
        System.out.println(configProperties.getKafkaServer());
        if(name.equals("sum")) {
            long result = counter.sumThenReset();
            System.out.println("sum is "+result);
        }
        else
            counter.increment();

        System.out.println(counter.toString());
        return String.format(template,name);
    }
}
