package com.h9.dododododod.mqttDemo.properties;

import lombok.Data;

@Data
public class MqttCustomer {
	
	private String clientIdPrefix;
	private String topics;
    private int qos;
    private long completionTimeout;
    

}
