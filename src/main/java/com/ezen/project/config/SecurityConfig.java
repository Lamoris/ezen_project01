/*
package com.ezen.project.config;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ezen.project.service.api.CustomOAuth2UserService;

@EnableWebSecurity
@Configuration
public class SecurityConfig{
	@Autowired
	CustomOAuth2UserService customOAuth2UserService;
	
	@Bean
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/member").hasRole("MEMBER")
		.anyRequest().authenticated()
		
		.and()
		.exceptionHandling().accessDeniedPage("/accessDenied")
		
		.and()
		.logout().logoutUrl("/logout")
		.logoutSuccessUrl("/").permitAll()
		
		.and()
		.oauth2Login().loginPage("/login")
		.userInfoEndpoint()
		.userService(customOAuth2UserService);
	}
}
*/