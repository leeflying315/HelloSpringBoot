package com.lifei.spring.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lifei
 * @Description: 生猪检测返回值Mock
 * @Date 2021/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PigDetectResp {

    Integer code;

    String msg;

    ResultImage result;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResultImage {
        String image;

        Integer count;
    }
}
