package com.petstoreapp.petapp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.petstoreapp.petapp.Entities.User;
import com.petstoreapp.petapp.Entities.UserProjection1;

import java.util.List;


@RepositoryRestResource(excerptProjection = UserProjection1.class)

public interface UserRepository extends CrudRepository<User, Integer> {
    //query methods -> methods in the repository,
    //created as per the structure of the entity
    //and these method calls will be converted into
    //SQL query by the hibernate. There are many
    //pre-defined query methods in the repository
    //but we can create more as per the required
    
    //custom query methods -> query methods created
    //by the developer for handling the request for
    //the particular case

    //While creating the query method take case of
    //the case, these methods have camelCase
    
    //we are using List because their is possibility
    //of more than one user with same firstname
    //name parameter value will be used to search 
    //the table
      
    List<User> findByFirstName(String firstName);
    User findByEmail(String email);
} 

