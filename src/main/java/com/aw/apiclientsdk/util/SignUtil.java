package com.aw.apiclientsdk.util;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import lombok.Data;

/**
 * @author Awei
 * @data 2024/4/20
 */
@Data
public class SignUtil {
    public static Digester md5 = new Digester(DigestAlgorithm.MD5);

    /**
     * 创建加密信息
     *
     * @param body      用户特征标识
     * @param secretKey 密钥
     * @return 标识
     */
    public static String genSign( String secretKey) {
        String signedTag = "." + secretKey;
        return md5.digestHex(signedTag);
    }

}
