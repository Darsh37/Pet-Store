package com.petstoreapp.petapp.Entities;

import org.hibernate.validator.constraints.Length;

import com.petstoreapp.petapp.Validators.Phone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;


// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor

@Data

@Entity

// @Table(name="user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "First Name should be not null")
    @NotBlank(message = "First Name should be not blank")
    private String firstName;

    @NotNull(message = "Last Name should be not null")
    @Length(min = 3, max = 10, message = "last name should have 3-10 characters")
    private String lastName;

    @NotNull(message = "email cannot be null")
    private String email;

    @NotNull(message = "Phone Number cannot be null")
    @Phone
    private String phone;

    private String password;

    @Transient
    //Transient will make sure the column 
    // of this field is not created in the table
    private String confirmPassword;

    
}
