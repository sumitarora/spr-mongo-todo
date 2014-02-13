package com.sumit.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	AccessDeniedHandlerImpl hl = new AccessDeniedHandlerImpl();
    	hl.setErrorPage("/accessdenied");
    	
        http
    	.csrf().disable()
    	.authorizeRequests()
    		.antMatchers("/assets/**").permitAll()
        	.antMatchers("/task/**").permitAll()
        	.antMatchers("/user/**").permitAll()
            .anyRequest().authenticated()
            .and()
        .logout()
        	.logoutSuccessUrl("/login")
        	.and()
        .formLogin()
            .loginPage("/login") 
            .permitAll();
    
        http.exceptionHandling().accessDeniedHandler(hl);
    }
}
