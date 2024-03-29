package com.petstoreapp.petapp.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petstoreapp.petapp.Entities.Product;
import com.petstoreapp.petapp.Repository.ProductRepository;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;


    // private Map<Integer, Product> productMap = new HashMap<>();
    // private AtomicInteger atomic = new AtomicInteger();

    public Product addProduct(Product newProduct){   
        return productRepository.save(newProduct);
    }

    public Iterable<Product> getAll(){
        //values method return collection<product>
        //we can convert this into an List by creating
        //and Arraylist using it
        return productRepository.findAll();
    }

    public Product getById(Integer id){
       return this.productRepository.findById(id).orElse(null);

    }

    public void deleteProduct(Integer id){
       this.productRepository.deleteById(id);
        
    }

    public Product UpdateProduct(Integer id,Product updateProduct){
        updateProduct.setId(id);
       return productRepository.save(updateProduct);
        

    }

    
}
