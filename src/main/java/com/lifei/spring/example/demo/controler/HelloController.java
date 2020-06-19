package com.lifei.spring.example.demo.controler;

import com.lifei.spring.example.demo.conf.ConfigProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.LongAdder;

@RestController
@Log4j2
public class HelloController {

    private static final String template = "Hello, %s!";
    private final LongAdder counter = new LongAdder();

    @Autowired
    private ConfigProperties configProperties;

    @RequestMapping("/hello")
    public String index(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println(configProperties.getKafkaServer());
        if (name.equals("sum")) {
            long result = counter.sumThenReset();
            log.info("sum is " + result);
        } else
            counter.increment();

        System.out.println(counter.toString());
        return String.format(template, name);
    }

    @RequestMapping("/first")
    public String first(){
        return "first controller";
    }
    @RequestMapping("/doError")
    public Object error() {
        return 1 / 0;
    }
}
