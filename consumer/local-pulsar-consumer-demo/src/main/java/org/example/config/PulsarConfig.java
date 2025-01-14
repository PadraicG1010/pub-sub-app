package org.example.config;

import org.apache.pulsar.client.api.*;
import org.example.listener.DemoMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PulsarConfig {

    @Bean
    public PulsarClient pulsarClient() throws PulsarClientException {
        return PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();
    }

    @Bean
//    @Scope("prototype")
    public DemoMessageListener demoMessageListener(){
        return new DemoMessageListener();
    }

    @Bean
    public Consumer<String> consumer1(PulsarClient pulsarClient, DemoMessageListener demoMessageListener) throws PulsarClientException {
        return pulsarClient.newConsumer(Schema.STRING)
                .topic("persistent://apache/pulsar/test-topics")
                .subscriptionName("my-subscription")
                .subscriptionType(SubscriptionType.Shared)
                .messageListener(demoMessageListener)
                .consumerName("Consumer 1")
                .subscribe();
    }

    @Bean
    public Consumer<String> consumer2(PulsarClient pulsarClient, DemoMessageListener demoMessageListener) throws PulsarClientException {
        return pulsarClient.newConsumer(Schema.STRING)
                .topic("persistent://apache/pulsar/test-topics")
                .subscriptionName("my-subscription")
                .subscriptionType(SubscriptionType.Shared)
                .messageListener(demoMessageListener)
                .consumerName("Consumer 2")
                .subscribe();
    }
}
