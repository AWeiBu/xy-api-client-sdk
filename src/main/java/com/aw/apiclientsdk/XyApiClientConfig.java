package com.aw.apiclientsdk;

import com.aw.apiclientsdk.client.XyApiClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Awei
 * @data 2024/4/16
 */

@Configuration
@ConfigurationProperties("xyapi.client")
@ComponentScan
@Data
public class XyApiClientConfig {

    private String accessKey;
    private String secretKey;

    @Bean
    public XyApiClient xyApiClient(){
        return new XyApiClient(accessKey,secretKey);
    }

}
