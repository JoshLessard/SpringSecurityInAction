package com.manning.ssia.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebAuthorizationConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
        return http
            .httpBasic( withDefaults() )
            .authorizeHttpRequests(
                c -> c.anyRequest().authenticated()
            )
            .authenticationProvider( new CustomAuthenticationProvider() )
            .build();
    }
}
