package com.lifei.spring.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @Author lifei
 * @Description: 自定义注解
 * @Date 2021/3/4
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name() default "test";
}
