package com.petstoreapp.petapp.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.petstoreapp.petapp.Entities.Orders;
import com.petstoreapp.petapp.Entities.Product;

import jakarta.persistence.ManyToMany;

//we are creating the custom rest api url here
//because if we don't do it the default url for orders
//will be orderses which does not seems logical

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrdesRepository extends JpaRepository<Orders,Integer> {
      
}
