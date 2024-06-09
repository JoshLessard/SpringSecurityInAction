package com.manning.ssia.configuration;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import static java.util.Collections.emptyList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate( Authentication authentication ) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf( authentication.getCredentials() );

        if ( "josh".equals( username ) && "pat33roy".equals( password ) ) {
            return new UsernamePasswordAuthenticationToken( username, password, emptyList() );
        } else {
            throw new AuthenticationCredentialsNotFoundException( "Error!" );
        }
    }

    @Override
    public boolean supports( Class<?> authenticationType ) {
        return UsernamePasswordAuthenticationToken.class
            .isAssignableFrom( authenticationType );
    }
}
