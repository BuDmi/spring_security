package ru.netology.task1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("Dima").password("{noop}qwerty").authorities("read", "write")
            .and()
            .withUser("Alex").password("{noop}12345").authorities("read");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .and()
            .authorizeRequests().antMatchers("/profile").permitAll()
            .and()
            .authorizeRequests().antMatchers("/read").hasAuthority("read")
            .and()
            .authorizeRequests().antMatchers("/write").hasAuthority("write")
            .and()
            .authorizeRequests().anyRequest().authenticated();
    }
}
