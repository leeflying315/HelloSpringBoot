package com.lifei.spring.example.demo.controler;

import com.lifei.spring.example.demo.dto.PigDetectResp;
import com.lifei.spring.example.demo.dto.Point;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@Log4j2
public class AIPigController {

    Random r = new Random(1);


    @PostMapping("/openapi/cv/pig/v1/detect")
    public PigDetectResp detectPig(@RequestParam(value = "imagefile")MultipartFile imagefile, @RequestParam(value = "region") List<Object> region){
        log.info("input region {} , name {}",region, imagefile.getOriginalFilename());

        PigDetectResp.ResultImage resultImage = new PigDetectResp.ResultImage();
        resultImage.setImage("http://172.30.125.90:8088/static/img/icon-66.87131739.svg");
        resultImage.setCount(r.nextInt());
        return PigDetectResp.builder()
                .code(0)
                .msg("ok")
                .result(resultImage)
                .build();

    }

    @PostMapping("/openapi/cv/pig/v1/weight")
    public PigDetectResp weightPig(@RequestParam(value = "imagefile")MultipartFile imagefile){
        log.info("input , name {}", imagefile.getOriginalFilename());

        PigDetectResp.ResultImage resultImage = new PigDetectResp.ResultImage();
        resultImage.setImage("http://172.30.125.90:8088/static/img/icon-66.87131739.svg");
        resultImage.setWeight(r.nextInt());
        return PigDetectResp.builder()
                .code(0)
                .msg("ok")
                .result(resultImage)
                .build();

    }
}
