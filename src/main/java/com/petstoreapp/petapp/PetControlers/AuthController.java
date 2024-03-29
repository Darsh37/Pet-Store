package com.petstoreapp.petapp.PetControlers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petstoreapp.petapp.Entities.User;

@RestController
public class AuthController {
    @PostMapping
    public ResponseEntity<?> register(@RequestBody User user){
        return ResponseEntity.ok("Done");
    }


    
}
