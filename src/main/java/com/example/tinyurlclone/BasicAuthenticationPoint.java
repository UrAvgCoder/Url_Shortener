package com.example.tinyurlclone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class BasicAuthenticationPoint {
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.antMatchers("/api/**").authenticated()).csrf().disable().formLogin();
		http.httpBasic();
		return http.build();
	}
}
