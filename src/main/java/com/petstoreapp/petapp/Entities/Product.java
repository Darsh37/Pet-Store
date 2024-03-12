package com.petstoreapp.petapp.Entities;

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
// @Table(name="product")
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    //we are telling the database to auto generate 
    //the unique id values
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Length(min=3, max = 20, message = "Product name should have 3-20 character")
    private String name;

    @Min(value = 0)
    @Max(value = 400)
    private Double price;
    private String description;
    
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instance CreateAt;
    @LastModifiedDate
    private Instance updateAt;
    

    

}