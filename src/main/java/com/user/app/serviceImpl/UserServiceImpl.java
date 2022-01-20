package com.user.app.serviceImpl;

import org.springframework.stereotype.Service;

import com.user.app.models.User;
import com.user.app.repository.UserRepository;
import com.user.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository; 
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User saveStudent(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		User user= userRepository.findByuserName(userName);
		return user;
		
	}


	@Override
	public User updateUserById(User user,String userName) {
		
		User oldStudent= userRepository.findByuserName(userName);
		oldStudent.setAddress1(user.getAddress1());
		oldStudent.setAddress2(user.getAddress2());
		oldStudent.setEmailID(user.getEmailID());
		oldStudent.setFirstName(user.getFirstName());
		oldStudent.setLastName(user.getLastName());
		oldStudent.setMobileNumber(user.getMobileNumber());
		oldStudent.setUserName(user.getUserName());
		userRepository.save(oldStudent);
		return oldStudent;
		
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteUserById(String userName) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userName);
		
	}
	
}
