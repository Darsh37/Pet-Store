package com.petstoreapp.petapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.petstoreapp.petapp.Entities.Product;

import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@CrossOrigin(origins = "*")
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
   
    //http://localhost:8080/products/search/findByName?name="red "

    @PreAuthorize("hasRole('HR')")
     List<Product> findByName(String name);


   @RolesAllowed("IT")
    //http://localhost:8080/products/search/findByPriceGreaterThanEqual?price=400
    List<Product> findByPriceGreaterThanEqual(Double price);

    @Secured("ROLE_HR")
    //http://localhost:8080/products/search/findByPriceLessThan?price=699
    List<Product>findByPriceLessThan(Double price);

    //http://localhost:8080/products/search/findByPriceBetween?low=100&high=300
    List<Product> findByPriceBetween(double low, double high);
}
    
 
