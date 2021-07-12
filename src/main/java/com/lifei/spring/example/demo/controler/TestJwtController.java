package com.lifei.spring.example.demo.controler;

import com.lifei.spring.example.demo.service.JwtService;
import com.lifei.spring.example.demo.service.Sample;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lifei
 * @Description:
 * @Date 2021/6/9
 */
@RestController
@Slf4j
public class TestJwtController {
    @Autowired
    JwtService jwtService;

    @Autowired
    Sample sample;

    @RequestMapping("/jwt")
    public String jwt(@RequestParam String accessKey, @RequestParam String accessSecret) throws Exception {
        return jwtService.createToken(accessKey, accessSecret);
    }

    @RequestMapping("/face")
    public String face(@RequestBody String image) throws Exception {
        return sample.test(image);
    }
}
