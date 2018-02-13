package com.sipa.auth;

import java.security.Principal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@EnableJdbcHttpSession
@RestController
public class AuthServer {

	public static void main(String[] args) {
		SpringApplication.run(AuthServer.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create().url("jdbc:postgresql://localhost:5432/auth")
				.username("vpn").password("vpn").driverClassName("org.postgresql.Driver").build();
	}
}
