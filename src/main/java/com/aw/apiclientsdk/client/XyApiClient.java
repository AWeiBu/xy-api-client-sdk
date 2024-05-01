package com.aw.apiclientsdk.client;

import cn.hutool.http.HttpRequest;
import com.aw.apiclientsdk.util.SignUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Awei
 * @data 2024/4/16
 */
@AllArgsConstructor
@Data
public class XyApiClient {
    public static final String GATEWAY_HOST = "http://121.40.127.69:8090";
    private String accessKey;
    private String secretKey;

    public String invokeApiByGet(String path) {
        return HttpRequest.get(GATEWAY_HOST + path)
                .addHeaders(genHeader())
                .execute().body();
    }

    private Map<String, String> genHeader() {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("accessKey", accessKey);
        headMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        headMap.put("sign", SignUtil.genSign(secretKey));
        return headMap;
    }
}
