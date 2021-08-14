package com.java.crm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories("com.java.crm.repository")
@SpringBootApplication()
public class CrmApplication {


    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }

}
