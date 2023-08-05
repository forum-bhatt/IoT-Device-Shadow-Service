package com.deviceshadow.service;

import com.amazonaws.services.iot.model.*;
import com.deviceshadow.dto.AppConfig;
import com.deviceshadow.util.AwsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateThingService {

    @Autowired
    private AwsConfig iotClient;
    @Autowired
    private AppConfig appConfig;

    public String createThingAutomatically(String thingName){
        //check if things already exists
        if (!describeThing(thingName)){
            //create thing
            CreateThingResult response = iotClient.getIotClient(appConfig)
                    .createThing(new CreateThingRequest()
                            .withThingName(thingName));
            System.out.println("Thing Created Successfully");
            return "Thing Created Successfully";
        }
            // thing exists
            return "Thing already exists";
    }

    private boolean describeThing(String thingName){
        if(thingName == null){
        return false;
        }
        try{
            DescribeThingResponse(thingName);
            return true;
        } catch(ResourceNotFoundException e) {
            return false;
        }
    }

    DescribeThingResult DescribeThingResponse(String thingName){
        DescribeThingRequest describeThingRequest = new DescribeThingRequest();
        describeThingRequest.setThingName(thingName);
        return iotClient.getIotClient(appConfig).describeThing(describeThingRequest);
    }

}
