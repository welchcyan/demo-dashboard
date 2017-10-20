package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SpringBootApplication
public class DemoApplication extends WebSecurityConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().and().csrf().ignoringAntMatchers("/admin/**");
		http.antMatcher("/**")
				.authorizeRequests()
				.antMatchers("/index.html", "/login", "/", "/api/catalog/**",
						"/user", "/assets/**").permitAll()
				.anyRequest().authenticated().and().csrf().disable();
	}
}