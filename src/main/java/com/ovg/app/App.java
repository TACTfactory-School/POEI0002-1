package com.ovg.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ovg.app.repositories.EventRepository;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private EventRepository eventRepository;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // this.userRepository.selectAll(connection);
    }

}
