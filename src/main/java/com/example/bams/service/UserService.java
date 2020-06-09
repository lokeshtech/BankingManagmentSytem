package com.example.bams.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bams.model.Address;
import com.example.bams.model.Role;
import com.example.bams.model.User;
import com.example.bams.repository.AddressRepository;
import com.example.bams.repository.RoleRepository;
import com.example.bams.repository.UserDAO;
import com.example.bams.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private AddressRepository addressRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserDAO userDao;
    
    

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       AddressRepository addressRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.addressRepository = addressRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User findUserById(int id) {
        return userRepository.findById(id);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public void saveUser(User user,Address adr,Address padr,String role) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(0);
        Role userRole = roleRepository.findByRole(role);
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
        addressRepository.save(adr);
        if(adr.getAtype().equals("CURRENT")) {
        	addressRepository.save(padr);
        }
    }
  
    public List<User> getAllUsers() {
    	return userDao.getAllUsers();
    }
    
    @Transactional
    public int updateCustomerId(int id,int custid) {
    return userDao.updateCustomerId(id, custid);
	}
}