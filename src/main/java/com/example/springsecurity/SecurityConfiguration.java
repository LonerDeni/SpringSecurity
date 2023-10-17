package com.example.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("Semen")
                    .password(encoder().encode("qwerty123"))
                    .authorities("ALL")
                    .and()
                    .withUser("Oleg")
                    .password(encoder().encode("qwerty124"))
                    .authorities("READ");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.GET,"/persons/by-city").hasAuthority("ALL")
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.GET,"/persons/by-age").hasAuthority("READ")
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.GET,"/persons/auth").permitAll()
                .and()
                .authorizeHttpRequests().anyRequest().authenticated();
    }
}
