package com.example.userapi;

import com.example.userapi.model.User;
import com.example.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserapiApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		User user1= new User();
		user1.setFirstName("Sonu");
		user1.setLastName("Kumar");
		user1.setUserName("Spidy");
		user1.setEmailId("spidy@gmail.com");
		user1.setMobileNumber("1234567890");
		user1.setAddress1("Nichlaul");
		user1.setAddress2("Maharajganj");
		userRepository.save(user1);
	}
}
