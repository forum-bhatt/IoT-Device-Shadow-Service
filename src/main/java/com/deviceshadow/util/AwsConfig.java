package com.deviceshadow.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.iot.AWSIot;
import com.amazonaws.services.iot.AWSIotClientBuilder;
import com.deviceshadow.dto.AppConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Configuration
public class AwsConfig {

    @Bean
    public AWSIot getIotClient(AppConfig appConfig){
        return AWSIotClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(appConfig.getAccessKeyId(), appConfig.getSecretKeyId())))
                .withRegion(Regions.US_EAST_2)
                .build();
    }
}
