package com.deviceshadow.util;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.deviceshadow.dto.PubMessage;
import com.deviceshadow.dto.PubMessage.MyMessage;
import com.deviceshadow.dto.WeatherPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class MqttConfig {
    //    MQTT Connection over websocket
    String clientEndpoint = "althpijq53owp-ats.iot.us-east-2.amazonaws.com";
    String clientId = "WeatherMonitor"; // replace with your own client ID. Use unique client IDs for concurrent connections.
    String awsAccessKeyId = "AKIAXLW4IACXM3DSNL5Y";
    String awsSecretAccessKey = "Q0jYbOd60nPbYWXI8urkXEWqXgmMpnVG/C8KWYEA";
    AWSIotMqttClient client = null;

    public void connectToIot() throws AWSIotException {
         client = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, null);
        client.connect();
        System.out.println("Connected to IoT");
    }

    public void publish(WeatherPayload payload) throws AWSIotException, JsonProcessingException {
        String topic = "weathertopic";
        AWSIotQos qos = AWSIotQos.QOS0;
        long timeout = 3000;

        ObjectMapper mapper = new ObjectMapper();

        PubMessage pubMessage = new PubMessage();
        MyMessage message = pubMessage.new MyMessage(topic, qos, mapper.writeValueAsString(payload));
        client.publish(message, timeout);

    }
    }

