package br.com.portfolio.basicform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class BasicFormApplication {

    public static void main(String... args){
        SpringApplication.run(BasicFormApplication.class, args);
    }

}
