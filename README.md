# IoT-Device-Shadow-Service
This project creates a Digital Device Shadow service by creating Things on AWS IoT with a Pub-Sub Architecture and a Lambda function for the authorizer. In order to monitor, a fleet hub application is created.

The Project revolves around creating a service that facilitates the following:

1. Creating Things On IOT
2. Attaching Policy and certificate to Things
3. Creating a Digital Device Shadow service
4. Publish and Subscribe to Device Shadow
5. Creating Custom Authorizer
6. Creating Lambda Function for the Authorizer
7. Creating a fleet hub application for Monitoring purposes

# Connected with AWS IoT using aws-device-sdk-java using the web socket connection method by Publishing and subscribing to a topic.

![image](https://github.com/forum-bhatt/IoT-Device-Shadow-Service/assets/90527629/15008a93-89de-4d1a-8639-34ee09b4f424)

# Publish Payload to Topic

# AWS IoT Core Shadow Concept
In the context of IoT (Internet of Things), shadows refer to a mechanism used in some IoT platforms to represent the state and desired state of devices or things. Shadows help maintain a consistent and synchronized view of the device's state between the physical device and the cloud-based IoT platform.

# What is a Device Shadow?
Device Shadow is a virtual representation of a physical device, viz. JSON Document, used to store the current state and desired state of any device.  It is a virtual representation of the device's attributes, such as temperature, humidity, status, etc. The device shadow is stored in the cloud and is updated regularly to reflect the real-time state of the physical device.
On AWS IoT-Core, each device is represented by a Thing that is created on the platform.

Device shadows have several benefits:

Offline Support: Device shadows allow IoT devices to function even when they are temporarily disconnected from the cloud. The device can continue operating based on the last known state stored in the shadow, and once it reconnects, the cloud platform will update the shadow with the latest state from the device.

Asynchronous Communication: IoT devices may have intermittent connectivity, and using shadows allows asynchronous communication between the device and the cloud. The device can update its shadow when it has data available, and the cloud can request updates from the shadow when it is online.

Simplified Device Management: By using shadows, device management becomes easier since the cloud can directly interact with the shadow to set the desired state of the device. The device can then work towards achieving that desired state.

# Types of Shadows
There are two types of Shadows:
1. Classic Shadows
- There can only be one Classic/Unnamed Shadow for a device.
- Limited usage, generally used for a single task
- For example, if an IoT platform wants to turn on a smart light bulb, it can set the state shadow to "ON," and the IoT device will receive the command and update its state accordingly.


2. Named Shadows
- Named shadows, in the context of IoT, can be considered as "desired state shadows."
- These represent the desired state that the cloud or an external system wants the physical IoT device to be in. 
- It is used to communicate commands or instructions to the IoT device.
- Used for multiple features of a single device/thing ex: Temperature tracker, Location Tracker, Remote door 
  lock/unlock etc.

# Creating Classic and Named Shadow
Creating Shadow Programmatically
Publishing and Subscribing to Device Shadow

