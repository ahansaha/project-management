package com.Souvik.pma.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.withDefaultSchema()
			.withUser("myuser")
				.password("pass")
				.roles("USER")
			.and()
			.withUser("taz")
				.password("taz2")
				.roles("USER")
			.and()
			.withUser("managerUser")
				.password("pass3")
				.roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder getPassWordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	//Specifying the things the logged in user can do. (Basically the authorization part of the user).
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/projects/new").hasRole("ADMIN")
			.antMatchers("/employees/new").hasRole("ADMIN")
			.antMatchers("/h2_console/**").permitAll()
			.antMatchers("/").authenticated().and().formLogin();
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
}
