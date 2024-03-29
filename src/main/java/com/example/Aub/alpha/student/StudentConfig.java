package com.example.Aub.alpha.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
    return args -> {
        Student miriam = new Student(
                "Miriam",
                "miriam.jamal@gmail.com",
                LocalDate.of(2010, JANUARY, 5),
                6,
                "123 Easy St",
                "Sarasota",
                "FL",
                12345);
        Student alex = new Student(
                "Alex",
                "alex@gmail.com",
                LocalDate.of(2006, MAY, 18), 10,
                "1273 Rockefeller St",
                "Somewhere",
                "FL",
                98765);
        Student sara = new Student(
                "Sara",
                "sara@gmail.com",
                LocalDate.of(2008, APRIL, 27), 8,
                "2100 Birchwood Dr",
                "Indiana",
                "PA",
                15701);
        repository.saveAll(List.of(miriam,alex,sara));
        };
    }
}
