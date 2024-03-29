package com.petstoreapp.petapp.Entities;

import java.time.Instant;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.petstoreapp.petapp.Validators.Phone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@EntityListeners(AuditingEntityListener.class)

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
    @Column(unique = true)
    private String email;

    @NotNull(message = "Phone Number cannot be null")
    @Phone
    private String phone;

    private String password;

    @Transient
    //Transient will make sure the column 
    // of this field is not created in the table
    private String confirmPassword;

    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    //one address belongs to only one user

    //here in the user table created for this User entity
    //we want to add foreign key column to refer the id 
    //of the address, use @JoinColumn annotation
    
    @OneToOne
    @JoinColumn(name="addr_id")
    private Address addr;
}
