package com.deviceshadow.controller;

import com.amazonaws.services.iot.client.AWSIotException;
import com.deviceshadow.dto.WeatherPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.deviceshadow.service.MqttPubSubService;

@RestController
public class MqttController {

//    auto wiring service class
    @Autowired
    MqttPubSubService service;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody WeatherPayload payload) throws AWSIotException {

        service.publishMessage(payload);

        return "Message Published Successfully";
    }
}
