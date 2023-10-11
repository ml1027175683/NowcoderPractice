package com.h9.dododododod.mqttDemo.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * mqtt配置信息读取
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "custom.mqtt")
public class MqttProperties {
	
	private String urls;
    private String username;
    private String password;
	private int keepAlive;
	private boolean sslenable;
	private String caCrtFile;
	
    private MqttCustomer customer;


}
