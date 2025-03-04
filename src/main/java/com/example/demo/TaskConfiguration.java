//package com.example.demo;
//
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class TaskConfiguration {
//
//    @Bean
//    CommandLineRunner commandLineRunner(TaskRepository repository) {
//        return args -> {
//            Task Inventory = new Task(
//                    "mandisi5000",
//                    "Do store inventory",
//                    "Get it done by the end of the day"
//
//            );
//
//            Task Prints = new Task(
//                    "james30",
//                    "Print pamphlets for outreach programme",
//                    "Use designs in the designs folder"
//            );
//
//            repository.saveAll(
//                    List.of(Inventory, Prints)
//            );
//
//        };
//    }
//}
