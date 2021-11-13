package com.shopingcart.rest.services.restfullwebservices.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/actuator/health", "/actuator")
                .antMatchers(HttpMethod.GET, "/products", "/products/**")
                .antMatchers(HttpMethod.GET, "/brands", "/brands/**")
                .antMatchers(HttpMethod.GET, "/categories", "/categories/**")
                .antMatchers("/swagger-ui/**", "/v3/api-docs/**")
                .antMatchers("/h2-console/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors()
                .and().authorizeRequests()
                .anyRequest().authenticated()
                .and().oauth2ResourceServer().jwt();
        Okta.configureResourceServer401ResponseBody(http);
    }
}