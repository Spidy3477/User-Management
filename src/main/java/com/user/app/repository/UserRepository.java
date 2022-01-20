package com.user.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.user.app.models.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByuserName(String userName);
}
