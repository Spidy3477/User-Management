package com.user.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.models.User;
import com.user.app.service.UserService;

@RestController
public class UserController {
	
	public UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/user")
	public ResponseEntity<String> saveStudent(@RequestBody User user){
		try {
			userService.saveStudent(user);
			return new ResponseEntity<String>("New User addded successfully",HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("Can't add user, check console please",HttpStatus.OK);
		}
	}
	@GetMapping("/user")
	public ResponseEntity<User> getStudentByuserName(@RequestParam("userId") String userName) {
		return new ResponseEntity<User>(userService.getUserByUserName(userName), HttpStatus.OK);
		
	}
	@PutMapping("/user")
	public ResponseEntity<User> updateStudent(@RequestParam("userId") String userName, @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUserById(user,userName), HttpStatus.OK);
	}
	@DeleteMapping("/user")
	public ResponseEntity<String> deleteStudent(@RequestParam("userId") String userName){
		try{
			userService.deleteUserById(userName);
			return new ResponseEntity<String>("Deleted successfully!",HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("do not exists",HttpStatus.OK);
		}
		
	}
	
}
