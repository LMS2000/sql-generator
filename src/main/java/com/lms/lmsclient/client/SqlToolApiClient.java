package com.lms.lmsclient.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.lmsclient.model.LmsRequest;
import com.lms.lmsclient.model.LmsResponse;
import com.lms.lmsclient.model.LmsResponseBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static com.lms.lmsclient.utils.SignUtils.genSign;


/**
 * 调用第三方接口的客户端
 *
 * @author LMS2000
 */
@AllArgsConstructor
@Slf4j
@NoArgsConstructor
@Data
public class SqlToolApiClient {

    private static final String HOST = "http://localhost:8090";

    private String accessKey;
    private String secretKey;


    /**
     * 根据请求获取生成数据
     * @param request
     * @return
     */
    public LmsResponseBody randomData(LmsRequest request) throws JsonProcessingException {



        String requestBodyJson = JSONUtil.toJsonStr(request);
        log.info("转换的请求json:"+requestBodyJson);

        HttpResponse response = HttpUtil.createPost(HOST + "/api/sql/generate/sdk")
                .addHeaders(getHeaderMap(requestBodyJson))
                .body(requestBodyJson)
                .execute();
        String responseBody = response.body();
        log.info("响应体："+responseBody);
        return getResponseData(responseBody);
    }


    private LmsResponseBody getResponseData(String body) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        LmsResponse<LmsResponseBody> lmsResponse = objectMapper.readValue(body, new TypeReference<LmsResponse<LmsResponseBody>>() {});
        return lmsResponse.getData();
    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        hashMap.put("Content-Type", "application/json; charset=UTF-8");
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, secretKey));
        log.info("生成的签字为:"+genSign(body,secretKey));
        return hashMap;
    }


}
