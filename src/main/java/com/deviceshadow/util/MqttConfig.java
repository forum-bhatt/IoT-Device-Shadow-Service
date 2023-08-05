package com.deviceshadow.util;

import com.amazonaws.services.iot.client.AWSIotDevice;
import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.deviceshadow.dto.AppConfig;
import com.deviceshadow.dto.PubMessage;
import com.deviceshadow.dto.PubMessage.MyMessage;
import com.deviceshadow.dto.WeatherPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqttConfig {
    //    MQTT Connection over websocket
    @Autowired
    private AppConfig appConfig;
    String clientId = "WeatherMonitor";
    AWSIotMqttClient client = null;
    private String clientEndpoint;
    private String awsAccessKeyId;
    private String awsSecretAccessKey;

        public void connectToIot() throws AWSIotException {
            clientEndpoint = appConfig.getClientEndpoint();
            awsAccessKeyId = appConfig.getAccessKeyId();
            awsSecretAccessKey = appConfig.getSecretKeyId();

            client = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, null);
            client.connect();
            System.out.println("Connected to IoT");
        }

        public void publish(WeatherPayload payload) throws AWSIotException, JsonProcessingException {
            String topic = "$aws/things/WeatherMonitor/shadow/name/WeatherMonitorNamed/update";
            AWSIotQos qos = AWSIotQos.QOS0;
            long timeout = 3000;

            ObjectMapper mapper = new ObjectMapper();
            AWSIotDevice device = new AWSIotDevice(clientId);
            String state = "{\"state\":{\"reported\":{\"sensor\":3.0}}}";
            client.attach(device);
            client.connect();

            PubMessage pubMessage = new PubMessage();
            MyMessage message = pubMessage.new MyMessage(topic, qos, state);
            client.publish(message, timeout);

        }
    }

