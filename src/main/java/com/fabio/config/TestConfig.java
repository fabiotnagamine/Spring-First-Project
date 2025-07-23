package com.fabio.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fabio.entities.Order;
import com.fabio.entities.User;
import com.fabio.entities.enums.OrderStatus;
import com.fabio.repositories.OrderRepository;
import com.fabio.repositories.UserRepository;

@Configuration
@Profile("test") // Mesmo nome que foi dado no application.properties (spring.profiles.active=test)
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(null, Instant.parse("2024-07-18T22:00:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2024-07-17T22:00:07Z"), OrderStatus.CANCELED, u1);
		orderRepository.saveAll(Arrays.asList(o1, o2));

	}	
	
}
