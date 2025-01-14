package org.example.listener;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageListener;

public class DemoMessageListener implements MessageListener<String> {
    @Override
    public void received(Consumer<String> consumer, Message<String> msg) {
        try {
            // Do something with the message

            // Acknowledge the message
            consumer.acknowledge(msg);
        } catch (Exception e) {
            // Message failed to process, redeliver later
            consumer.negativeAcknowledge(msg);
        }
        System.out.println("Consumer: " + consumer.getConsumerName() + " " + consumer.getStats().getNumAcksSent());
    }
}
