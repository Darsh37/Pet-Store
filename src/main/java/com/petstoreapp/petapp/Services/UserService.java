package com.petstoreapp.petapp.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petstoreapp.petapp.Entities.User;
import com.petstoreapp.petapp.Repository.UserRepository;
import com.petstoreapp.petapp.Repository.UserRepository;

@Service
public class UserService {

   @Autowired
   UserRepository userRepository; 
    // private Map<Integer, User> userMap = new HashMap<>();
    // private List<User> userList = new ArrayList<>();
    // private AtomicInteger atomic = new AtomicInteger();


       public User addUser(User newUser){
       return userRepository.save(newUser);
        
       }

       public Iterable<User> getAll(){
        return userRepository.findAll();
       }

       public User getUserById(Integer id){
        return userRepository.findById(id).orElse(null);
       }


    public User updateUser(Integer id, User updatedUser){
        updatedUser.setId(id);
        return this.userRepository.save(updatedUser);
    }

    //Delete
    public void deleteUser(Integer id){
       this.userRepository.deleteById(id);;
        
    }
}


    
