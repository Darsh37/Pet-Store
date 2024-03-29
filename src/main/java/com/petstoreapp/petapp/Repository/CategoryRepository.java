package com.petstoreapp.petapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petstoreapp.petapp.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
