package com.ovg.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

//  implements CommandLineRunner
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.boot.CommandLineRunner;
//	import com.ovg.app.repositories.EventRepository;
//    @Autowired
//    private EventRepository eventRepository;

//    @Override
//    public void run(String... args) throws Exception {
//        // this.userRepository.selectAll(connection);
//    }
}
