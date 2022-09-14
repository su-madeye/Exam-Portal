package com.example.examserver;

import com.example.examserver.models.Role;
import com.example.examserver.models.User;
import com.example.examserver.models.UserRole;
import com.example.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("works!");
		User user = new User();
		user.setFirstName("Prakhar");
		user.setLastName("Tibrewal");
		user.setEmail("abc@gmail.com");
		user.setUsername("prakhar");
		user.setPhone("1231231234");
		user.setPassword("abc");

		Role role = new Role();
		role.setRoleId(3456L);
		role.setRoleName("ADMIN");

		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);

		userService.createUser(user, userRoles);

	}
}
