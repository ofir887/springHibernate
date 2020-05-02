package com.example.springhibernate.springhibernate;

import com.example.springhibernate.springhibernate.repositories.BankRepository;
import com.example.springhibernate.springhibernate.repositories.ClientRepository;
import com.example.springhibernate.springhibernate.services.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringhibernateApplication implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BankRepository bankRepository;

    @Autowired
    Config.Test test;


    public static void main(String[] args) {

        SpringApplication.run(SpringhibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(clientRepository.findAll());
        System.out.println(bankRepository.findAll());
    }
}
