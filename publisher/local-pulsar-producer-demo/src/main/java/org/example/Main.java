package org.example;

import org.example.service.PulsarProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private PulsarProducerService pulsarProducerService;

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        pulsarProducerService.sendMessage("This is a message from the producer, hello!!!!");
    }
}