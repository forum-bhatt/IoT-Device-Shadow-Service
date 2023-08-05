package com.deviceshadow.dto;

import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotQos;

public class PubMessage {

    public class MyMessage extends AWSIotMessage {
        public MyMessage(String topic, AWSIotQos qos, String payload) {
            super(topic, qos, payload);
        }

        @Override
        public void onSuccess() {
            System.out.println("Message Published Successfully");
        }

        @Override
        public void onFailure() {
            System.out.println("Message Publishing Failed");
        }

        @Override
        public void onTimeout() {
            System.out.println("The Session has Timedout");
        }
    }


}
