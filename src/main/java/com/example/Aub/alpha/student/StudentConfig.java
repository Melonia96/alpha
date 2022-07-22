package com.example.Aub.alpha.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
    return args -> {
        Student miriam = new Student(
                "Miriam",
                "miriam.jamal@gmail.com",
                LocalDate.of(2000, JANUARY, 5),
                21);
        Student alex = new Student(
                "Alex",
                "alex@gmail.com",
                LocalDate.of(2000, JANUARY, 5),
                21);
        repository.saveAll(List.of(miriam,alex));
        };
    }
}
