package com.thejas.banking.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.authentication.AuthenticationFilter;

import java.util.List;

@Configuration
public class OAuth2Config {

    @Bean
    public JwtIssuerAuthenticationManagerResolver authenticationManagerResolver() {
        return new JwtIssuerAuthenticationManagerResolver(
                List.of(
                        "https://your-auth-provider.com" // Replace with your OAuth2 issuer
                )
        );
    }

    @Bean
    public BearerTokenAuthenticationFilter authenticationFilter(JwtIssuerAuthenticationManagerResolver authenticationManagerResolver) {
        return new BearerTokenAuthenticationFilter(authenticationManagerResolver);
    }
}
