//package org.example.service;
//
//import jakarta.annotation.PreDestroy;
//import org.apache.pulsar.client.api.*;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PulsarConsumerService {
//
//    private PulsarClient pulsarClient;
//    int i = 0;
//    int x = 0;
//
//    private final Consumer<byte[]> consumer1;
//    private final Consumer<byte[]> consumer2;
//
//    public PulsarConsumerService(PulsarClient pulsarClient) throws PulsarClientException {
//        this.consumer1 = pulsarClient.newConsumer()
//                .topic("persistent://apache/pulsar/test-topic")
//                .subscriptionName("my-subscription")
//                .subscriptionType(SubscriptionType.Shared)
//                .subscribe();
//
//        this.consumer2 = pulsarClient.newConsumer()
//                .topic("persistent://apache/pulsar/test-topic")
//                .subscriptionName("my-subscription")
//                .subscriptionType(SubscriptionType.Shared)
//                .subscribe();
//
//    }
//
//    public void consumeMessage1() throws PulsarClientException {
//        while (true) {
//            // Wait for a message
//            Message msg = consumer1.receive();
//
//            try {
//                // Do something with the message
//                i++;
//                System.out.println("Message number: " + i + " received by consumer 1: " + new String(msg.getData()));
//
//                // Acknowledge the message
//                consumer1.acknowledge(msg);
//            } catch (Exception e) {
//                // Message failed to process, redeliver later
//                consumer1.negativeAcknowledge(msg);
//            }
//        }
//    }
//
//    public void consumeMessage2() throws PulsarClientException{
//        while(true){
//            Message msg =consumer2.receive();
//
//            try {
//                // Do something with the message
//                x++;
//                System.out.println("Message number: " + x + " received by consumer 2: " + new String(msg.getData()));
//
//                // Acknowledge the message
//                consumer2.acknowledge(msg);
//            } catch (Exception e) {
//                // Message failed to process, redeliver later
//                consumer2.negativeAcknowledge(msg);
//            }
//        }
//    }
//
//    @PreDestroy
//    public void cleanUp() {
//        try {
//            consumer1.close();
//        } catch (PulsarClientException e) {
//            e.printStackTrace();
//        }
//
//        try{
//            consumer2.close();
//        } catch (PulsarClientException e){
//            e.printStackTrace();
//        }
//    }
//}
