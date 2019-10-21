package com.wipro.hca.vendingmachine.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.wipro.hca.vendingmachine"})
@EnableJpaRepositories(basePackages = {"com.wipro.hca.vendingmachine.repository"})
@EntityScan(basePackages = {"com.wipro.hca.vendingmachine.entity"})
public class VendingMachineApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(VendingMachineApplication.class, args);
	}

}
