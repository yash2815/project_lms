package com.example.leavemanagamentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@SpringBootApplication()
@ComponentScan({"com.example.leavemanagamentsystem.Service","com.example.leavemanagamentsystem.Controller",
	"com.example.leavemanagamentsystem.Repository"})
@EntityScan("com.example.leavemanagamentsystem")
//@EnableJpaRepositories("com.example.leavemanagamentsystem.Repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
