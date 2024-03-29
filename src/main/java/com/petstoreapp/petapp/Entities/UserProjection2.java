package com.petstoreapp.petapp.Entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "userprojection2", types = { User.class })
public interface UserProjection2 {
    Integer getId();

    String getFirstName();

    String getLastName();

}
