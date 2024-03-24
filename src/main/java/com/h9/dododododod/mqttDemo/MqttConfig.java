package com.h9.dododododod.mqttDemo;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.h9.dododododod.mqttDemo.properties.MqttProperties;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import javax.annotation.Resource;
import java.util.Map;



//@Slf4j
//@Configuration
public class MqttConfig {

	// 入站通道名（消费者）
	public static final String CHANNEL_NAME_IN = "mqttInboundChannel";
	public static final String FACTORY_NAME = "mqttPahoClientFactory";
	public static final String OPTIONS_NAME = "mqttConnectOptions";

	@Resource
	private MqttProperties mqttProperties;


	/**
	 * MQTT连接器选项
	 * @throws Exception
	 */
	@Bean(name = OPTIONS_NAME)
	public MqttConnectOptions mqttConnectOptions() throws Exception {
		MqttConnectOptions options = new MqttConnectOptions();
		// 设置连接的用户名
		options.setUserName(mqttProperties.getUsername());
		// 设置连接的密码
		options.setPassword(mqttProperties.getPassword().toCharArray());
		options.setServerURIs(mqttProperties.getUrls().split(","));
		// 设置会话心跳时间，默认60秒。服务器会每隔（1.5 * KeepAlive）秒的时间向客户端发送心跳判断客户端是否在线，但这个方法并没有重连的机制
		options.setKeepAliveInterval(mqttProperties.getKeepAlive());
		// 设置是否清空session，false表示服务器会保留客户端的连接记录，true表示每次连接到服务器都以新的身份连接
		options.setCleanSession(true);
		// 允许同时发送的消息数量，默认10
		options.setMaxInflight(10);
		// 设置超时时间，默认30秒
		options.setConnectionTimeout(30);
		// 自动重连
		options.setAutomaticReconnect(true);
		return options;
	}

	/**
	 * MQTT客户端
	 *
	 */
	@Bean(name = FACTORY_NAME)
	public MqttPahoClientFactory mqttPahoClientFactory(@Qualifier(OPTIONS_NAME) MqttConnectOptions options) {
		DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
		factory.setConnectionOptions(options);
		return factory;
	}

	/**
	 * MQTT消费端订阅通道（消息入站）
	 *
	 */
	@Bean(name = CHANNEL_NAME_IN)
	public MessageChannel inboundChannel() {
		return new DirectChannel();
	}

	/**
	 * MQTT消费端连接配置（消息入站）
	 *
	 */
	@Bean
	public MessageProducer inbound(@Qualifier(CHANNEL_NAME_IN) MessageChannel channel,
			@Qualifier(FACTORY_NAME) MqttPahoClientFactory factory) {
		// 可以同时消费（订阅）多个Topic
		MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
				mqttProperties.getCustomer().getClientIdPrefix() + "_in_bound", factory,
				mqttProperties.getCustomer().getTopics().split(","));
		// 设置操作完成的超时时长，默认30000毫秒
		adapter.setCompletionTimeout(mqttProperties.getCustomer().getCompletionTimeout());
		// 配置默认消息转换器(qos=0, retain=false, charset=UTF-8)
		adapter.setConverter(new DefaultPahoMessageConverter());
		// 0 至多一次，数据可能丢失
		// 1 至少一次，数据可能重复
		// 2 只有一次，且仅有一次，最耗性能
		adapter.setQos(mqttProperties.getCustomer().getQos());
		// 设置订阅通道
		adapter.setOutputChannel(channel);
		return adapter;
	}

	/**
	 * MQTT消费端消息处理器（消息入站）
	 *
	 */
	@Bean
	@ServiceActivator(inputChannel = CHANNEL_NAME_IN)
	public MessageHandler inboundHandler() {
		return new MessageHandler() {
			@SneakyThrows
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				Map<String, Object> headers = message.getHeaders();
				String topic = headers.get("mqtt_receivedTopic").toString();


				//String msg = new String((byte[]) message.getPayload(),"GB2312");
				if ("dev1metadata".equals(topic)){
				 JSONUtil.parseObj(message.getPayload());



				}else if ("dev1seriesdata".equals(topic)){

				}else if ("test01".equals(topic)){
					JSONObject jsonObject = JSONUtil.parseObj(message.getPayload());
					System.out.println(jsonObject.toString());
				}else if ("test02".equals(topic)){
					JSONObject jsonObject = JSONUtil.parseObj(message.getPayload());
					System.out.println(jsonObject.toString());
				}

			}
		};
	}



}
