package com.deviceshadow.controller;

import com.amazonaws.services.iot.model.AWSIotException;
import com.deviceshadow.dto.WeatherPayload;
import com.deviceshadow.service.CreateThingService;
import com.deviceshadow.util.MqttConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class MqttController {

//    auto wiring service class
    @Autowired
    MqttConfig mqttConfig;

    @Autowired
    CreateThingService createThingService;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody WeatherPayload payload) throws IOException, JsonProcessingException {

        mqttConfig.publishToShadow();

        return "Message Published Successfully";
    }

    //    expose rest endpoint for device registering
    @PostMapping("/register/{thingName}")
    public String createThing(@PathVariable String thingName){
        return createThingService.createThingAutomatically(thingName);
    }
}
