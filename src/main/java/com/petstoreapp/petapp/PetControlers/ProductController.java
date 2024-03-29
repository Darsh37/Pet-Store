package com.petstoreapp.petapp.PetControlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petstoreapp.petapp.Entities.Product;
import com.petstoreapp.petapp.Services.ProductService;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

// @RestController
public class ProductController {

    @Autowired
    public ProductService productService;

    @PostMapping("/products")
    //@RequrestBody annototion will convert the JSON data
    //coming in the rquest body into the object of the class product

    public ResponseEntity<Product> addProduct(@RequestBody @Valid Product newproduct){  
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.addProduct(newproduct));
    }

    //Read all
    @GetMapping("/products")
    public ResponseEntity<?> getPetDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.getAll());
    }

    //Read single
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        
        Product founProduct = this.productService.getById(id);
        if(founProduct == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product with this ID does not exist");
        else
        return ResponseEntity.ok(founProduct);

    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        Product fProduct = this.productService.getById(id);
        if(fProduct == null)
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product with this ID does not exist");
           else
           {
            this.productService.deleteProduct(id);
            //When the delete operation is done we don't
            //want to return any response
            return ResponseEntity.ok("Product delete succesfully");
           }

        }

        @PutMapping("/products/{id}")
        public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product uProduct){
            Product fProduct = this.productService.getById(id);
            if(fProduct == null)
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product with this ID does not exist");
            else
              return ResponseEntity.ok(this.productService.UpdateProduct(id, uProduct));
    

        }

    
}
