package com.lifei.spring.example.demo.service;

import com.baidu.aip.face.AipFace;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author lifei
 * @Description:
 * @Date 2021/6/29
 */
@Service
@Slf4j
public class Sample {
    public static final String APP_ID = "24459307";
    public static final String API_KEY = "6dMRvINfbyp9sB1RTLKgX6G4";
    public static final String SECRET_KEY = "PniDQTVcMy1HjcaMcuK5i31KNtAr33l9";

    public String test(String image) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        // 人脸检测
//        JSONObject res = client.detect(image, imageType, options);
//        System.out.println(res.toString(2));
        getAllFaceGroup(client);
        return sample(client, image);

    }

    public String sample(AipFace client, String image) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "3");
        options.put("match_threshold", "70");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
//        options.put("user_id", "233451");
        options.put("max_user_num", "3");

        String imageType = "BASE64";
        String groupIdList = "face";

        // 人脸搜索
        JSONObject res = client.search(image, imageType, groupIdList, options);
        System.out.println(res.toString(2));
        return res.toString();
    }

    public void getAllFaceGroup(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("start", "0");
        options.put("length", "50");
        // 组列表查询
        JSONObject res = client.getGroupList(options);
        System.out.println(res.toString(2));

    }

    public void getFace(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();

        String userId = "user1";
        String groupId = "group1";

        // 获取用户人脸列表
        JSONObject res = client.faceGetlist(userId, groupId, options);
        System.out.println(res.toString(2));

    }
}
