package org.example.javaspringbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class JavaSpringBootStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootStudyApplication.class, args);
    }

}
