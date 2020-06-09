package com.example.bams.repository;

import java.util.List;

import com.example.bams.model.User;

public interface UserDAO {

	List<User> getAllUsers();
	public int updateCustomerId(int id,int custid);
}
