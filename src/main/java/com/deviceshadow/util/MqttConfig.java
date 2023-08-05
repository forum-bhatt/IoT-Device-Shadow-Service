package com.deviceshadow.util;

import com.amazonaws.services.iotdata.model.PublishRequest;
import com.deviceshadow.dto.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Component
public class MqttConfig {
    //    MQTT Connection over websocket
    @Autowired
    private AwsConfig iotClient;

    @Autowired
    private AppConfig appConfig;

    public void publishToShadow() throws IOException {

        String topic = "$aws/things/WeatherMonitor/shadow/name/WeatherMonitorNamed/update";

        String payload = "{\"state\":{\"reported\":{\"sensor\":3.0}}}";
        ByteBuffer bb = StandardCharsets.UTF_8.encode(payload);
        PublishRequest publishRequest = new PublishRequest();
        publishRequest.withPayload(bb);
        publishRequest.withTopic(topic);
        publishRequest.setQos(0);
        iotClient.getIotDataClient(appConfig).publish(publishRequest);
        System.out.println("Message Published successfully");
    }
//    @Autowired
//    private AppConfig appConfig;
//    String clientId = "WeatherMonitor";
//    AWSIotMqttClient client = null;
//    private String clientEndpoint;
//    private String awsAccessKeyId;
//    private String awsSecretAccessKey;
//
//        public void connectToIot() throws AWSIotException {
//            clientEndpoint = appConfig.getClientEndpoint();
//            awsAccessKeyId = appConfig.getAccessKeyId();
//            awsSecretAccessKey = appConfig.getSecretKeyId();
//
//            client = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, null);
//            client.connect();
//            System.out.println("Connected to IoT");
//        }
//
//        public void publish(WeatherPayload payload) throws AWSIotException, JsonProcessingException {
//            String topic = "$aws/things/WeatherMonitor/shadow/name/WeatherMonitorNamed/update";
//            AWSIotQos qos = AWSIotQos.QOS0;
//            long timeout = 3000;
//
//            ObjectMapper mapper = new ObjectMapper();
//            AWSIotDevice device = new AWSIotDevice(clientId);
//            String state = "{\"state\":{\"reported\":{\"sensor\":3.0}}}";
//            client.attach(device);
//            client.connect();
//
//            PubMessage pubMessage = new PubMessage();
//            MyMessage message = pubMessage.new MyMessage(topic, qos, state);
//            client.publish(message, timeout);
//
//        }

    }

