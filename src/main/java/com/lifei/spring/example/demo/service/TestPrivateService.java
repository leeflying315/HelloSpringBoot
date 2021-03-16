package com.lifei.spring.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author lifei
 * @Description:
 * @Date 2021/3/3
 */
@Service
@Slf4j
public class TestPrivateService {

    public void test(){
        log.info("execute test");
    }
}
