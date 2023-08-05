package com.deviceshadow.service;


import com.amazonaws.services.iot.client.AWSIotException;
import com.deviceshadow.dto.WeatherPayload;
import com.deviceshadow.util.MqttConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttPubSubService {

    @Autowired
    MqttConfig mqttconfig;
    public void publishMessage(WeatherPayload payload) throws AWSIotException {
        mqttconfig.connectToIot();
        mqttconfig.publish(payload);
    }
}