package com.petstoreapp.petapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petstoreapp.petapp.Entities.Product;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
   
    //http://localhost:8080/products/search/findByName?name="red "
    List<Product> findByName(String name);

    //http://localhost:8080/products/search/findByPriceGreaterThanEqual?price=400
    List<Product> findByPriceGreaterThanEqual(Double price);

    //http://localhost:8080/products/search/findByPriceLessThan?price=699
    List<Product>findByPriceLessThan(Double price);

    //http://localhost:8080/products/search/findByPriceBetween?low=100&high=300
    List<Product> findByPriceBetween(double low, double high);
}
    
 
