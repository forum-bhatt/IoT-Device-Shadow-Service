package com.deviceshadow.util;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import org.springframework.stereotype.Component;

@Component
public class MqttConfig {
    //    MQTT Connection over websocket
    String clientEndpoint = "althpijq53owp-ats.iot.us-east-2.amazonaws.com";
    String clientId = "WeatherMonitor"; // replace with your own client ID. Use unique client IDs for concurrent connections.
    String awsAccessKeyId = "AKIAXLW4IACXM3DSNL5Y";
    String awsSecretAccessKey = "Q0jYbOd60nPbYWXI8urkXEWqXgmMpnVG/C8KWYEA";

    public void connectToIot() throws AWSIotException {
        AWSIotMqttClient client = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, null);
        client.connect();
        System.out.println("Connected to IoT");
    }
    }

