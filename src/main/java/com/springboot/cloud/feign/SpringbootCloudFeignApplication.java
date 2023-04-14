package com.springboot.cloud.feign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cloud.feign.client.UserClient;
import com.springboot.cloud.feign.dto.UserResponse;

@SpringBootApplication
@RestController
@EnableFeignClients
public class SpringbootCloudFeignApplication {

	@Autowired
	private UserClient userClient;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCloudFeignApplication.class, args);
	}

	@GetMapping("/findalluser")
	public List<UserResponse> getAllUsers(){
		return userClient.getUsers();
	}
}
