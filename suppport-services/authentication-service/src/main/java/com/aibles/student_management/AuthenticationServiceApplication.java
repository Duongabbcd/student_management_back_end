package com.aibles.student_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;


@SpringBootApplication
public class AuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);

	}


	@Bean
	public CorsFilter corsFilter(){
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");

		config.setAllowedMethods(Arrays.asList("POST"));
		config.setAllowedMethods(Arrays.asList("put"));
		config.setAllowedMethods(Arrays.asList("GET"));
		config.setAllowedMethods(Arrays.asList("DELETE"));
		config.setAllowedMethods(Arrays.asList("OPTIONS"));
		config.setAllowedMethods(Arrays.asList("HEAD"));
		config.setAllowedMethods(Arrays.asList("PATCH"));

		source.registerCorsConfiguration("/**",config);
		return new CorsFilter(source);
	}
}
