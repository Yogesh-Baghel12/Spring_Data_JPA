package com.luv2code.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurity {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john=User.builder()
           .username("john")
           .password("{noop}test123")
           .roles("Students")
           .build();
           UserDetails Marry=User.builder()
           .username("Marry")
           .password("{noop}test1234")
           .roles("Students","Manager")
           .build();
           UserDetails susan=User.builder()
           .username("susan")
           .password("{noop}test12345")
           .roles("Students","Manager","Admin")
           .build();

        return new InMemoryUserDetailsManager(john,Marry,susan);
    }
    
     @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
        configurer
        .requestMatchers(HttpMethod.GET,"/magic-ap/students").hasRole("Students")
        .requestMatchers(HttpMethod.GET,"/magic-ap/students/**").hasRole("Students")
        .requestMatchers(HttpMethod.PUT,"/magic-ap/students").hasRole("Manager")
        .requestMatchers(HttpMethod.POST,"/magic-ap/students").hasRole("Manager")
        .requestMatchers(HttpMethod.DELETE,"/magic-ap/students/**").hasRole("Admin"));

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());

        return http.build();

    }
    
}
