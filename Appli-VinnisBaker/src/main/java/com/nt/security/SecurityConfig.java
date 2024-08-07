package com.nt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nt.service.CustomUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(authorize -> authorize
	            .requestMatchers("/", "/shop/**", "/register", "/signup", "/login").permitAll()
	            .requestMatchers("/resources/**", "/static/**", "/images/**", "/productImage/**","/createadmin").permitAll()
	            .requestMatchers("/admin/**").permitAll()
	            .requestMatchers("/addToCart","/cart/**").authenticated()
	        )
	        .formLogin(form -> form
	            .loginPage("/login")	
	            .loginProcessingUrl("/custom-login") // This URL should match the form action URL
	            .usernameParameter("email") // Ensure this matches the form field name for username
	            .passwordParameter("password") // Ensure this matches the form field name for password
	            .defaultSuccessUrl("/", true) // Redirect to home on successful login
	            .permitAll()
	        )
	        .logout(logout -> 
            logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
        );
	    return http.build();
	}

	
	@Bean 
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(customuserservice());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean 
	public CustomUserService customuserservice() {
		return new CustomUserService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
