package org.example.service;

import jakarta.annotation.PreDestroy;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.example.config.PulsarConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PulsarProducerService {

    private final Producer<String> producer;

    //constructor will create topic if not already exists
    @Autowired
    public PulsarProducerService(PulsarClient pulsarClient) throws PulsarClientException {
        this.producer = pulsarClient.newProducer(Schema.STRING)
                .topic("persistent://apache/pulsar/test-topics")
                .create();
    }

    //method to send messages to the topic this producer is set to
    public void sendMessage(String message) throws PulsarClientException {
        for (int i = 0; i < 1000; i++) {
            producer.send(message);
            System.out.println("Message number " + i + " sent: " + message);
        }
    }

    //this just closes producer on app shutdown
    @PreDestroy
    public void cleanUp(){
        try{
            producer.close();
        } catch (PulsarClientException e){
            e.printStackTrace();
        }
    }
}
