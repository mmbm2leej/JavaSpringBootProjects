package com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA.ConsoleColorSettings.*;

@SpringBootApplication
public class HotelApplication {

    public static void main(String[] args) {

        ApplicationContext myContext = SpringApplication.run(HotelApplication.class, args);
    }

/*
    @Bean
    CommandLineRunner myCLR() {



        return null;
    }
*/
}

