package com.lifei.spring.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//源码可以看到它具有@SpringBootConfiguration、@EnableAutoConfiguration和@ComponentScan三个注解的作用
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
