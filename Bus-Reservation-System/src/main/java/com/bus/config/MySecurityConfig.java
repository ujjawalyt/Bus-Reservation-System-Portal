package com.bus.config;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.bus.service.CustomUserDetailsService;


//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//
//   @Autowired
//   private CustomUserDetailsService  customUserDetailsService;
//    
//    @Override
//	protected void configure(HttpSecurity http) throws Exception{
//		http.csrf().disable()
//		.authorizeRequests()
//    		.antMatchers("/customer/add").permitAll()
//    		.antMatchers("/customer/**").hasRole("USER")
//    		
//    		.anyRequest().authenticated()
//    		.and()
//    		.formLogin();
//    		
//	}
//    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//    }
//    
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    
//   
//}


