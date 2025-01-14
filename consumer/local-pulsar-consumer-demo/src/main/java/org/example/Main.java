package org.example;

import org.apache.pulsar.client.api.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private Consumer<String> consumer1;

    @Autowired
    private Consumer<String> consumer2;

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
    }
}