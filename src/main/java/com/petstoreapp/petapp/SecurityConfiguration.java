package com.petstoreapp.petapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(
    prePostEnabled = true,
    jsr250Enabled = true,
    securedEnabled = true
    
)
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                // here all the HTTP request methods are allowed

                .requestMatchers(HttpMethod.GET, "products/**")
                .permitAll()
                .requestMatchers(HttpMethod.POST, "products/**")
                .permitAll()
                .requestMatchers("/users/**")
                .hasRole("HR")
                .requestMatchers("/orders")
                .hasRole("IT")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

    // For authentication, we will save the password in the encoded format while
    // registering the user
    // This is will also be needed to encode the incoming password of the user

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService registerUsers() {
        UserDetails user1 = User.withUsername("Darshana")
                .password(passwordEncoder().encode("1234"))
                .roles("HR")
                .build();
        UserDetails user2 = User.withUsername("Mangesh")
                .password(passwordEncoder().encode("1234"))
                .roles("HR")
                .build();

        UserDetails user3 = User.withUsername("Ram")
                .password(passwordEncoder().encode("1234"))
                .roles("IT")
                .build();

    // InMemoryUserDetailsManager implements UserDetailsService and is used to store
    // user details in the memory. But this is used only when we have small number
    // of users
    // interacting with the application. If there are more users then we will
    // implement
    // authentication using Database
        return new InMemoryUserDetailsManager(user1, user2,user3);
    }

   

}
