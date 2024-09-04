package com.RESTApi.RESTAPI.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class EmployeeSecConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){


        UserDetails omran= User.builder()
                .username("omran")
                .password("{noop}omran123")
                .roles("EMPLOYEE")
                .build();

        UserDetails ali= User.builder()
                .username("ali")
                .password("{noop}ali123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails moh= User.builder()
                .username("moh")
                .password("{noop}moh123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(omran,ali,moh);
    }
}
