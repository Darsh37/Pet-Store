package com.petstoreapp.petapp.Entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;


//Projection is the subset of the data from the entity
//rather than showing all the field in the result,
//we can restrict the field as per our selection

@Projection(name="userprojection1", types = User.class)
public interface UserProjection1 {
   
    //whichever field we want in the result,
    //we will create its getter methods in this interface

    // String getFirstName();
    // String getLastName();

    //closed projection => fields of the original class
    //are mapped as it is
    String getEmail();
    String  getPhone();

    //open projection => we can create new fields using 
    //the values of the original fields
    //here target is the User class
    @Value("#{target.firstName+' '+target.lastName}")
    String getName();

    
}
