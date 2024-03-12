package com.petstoreapp.petapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petstoreapp.petapp.Entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    
} 
