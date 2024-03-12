package com.petstoreapp.petapp.PetControlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petstoreapp.petapp.Entities.User;
import com.petstoreapp.petapp.Repository.UserRepository;
import com.petstoreapp.petapp.Services.UserService;

import jakarta.validation.Valid;

// @RestController
public class UserController {
    @Autowired
    public UserService service;

    @PostMapping("/users")
    public ResponseEntity<User> adduser(@RequestBody @Valid User nUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.addUser(nUser));
    }
    
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok().body(this.service.getAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        User foundUser = this.service.getUserById(id);
        if(foundUser== null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User wtih this id is does not exist");

        }
        else     
       return ResponseEntity.ok(foundUser);

    }

    @PutMapping("users/{id}")
    public ResponseEntity<?> updateuser(@PathVariable Integer id, @RequestBody User updateUser){
        User foundUser = this.service.getUserById(id);
        if(foundUser== null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User wtih this id is does not exist");

        }
        else     
       {
        return ResponseEntity.ok(this.updateuser(id, updateUser));
       }
        


    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        User founUser = this.service.getUserById(id);
        if(founUser==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found with this id");

        }
        else{
            this.service.deleteUser(id);
            return ResponseEntity.ok("Delete User Successfully");
        }
    }
}
