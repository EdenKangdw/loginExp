package com.example.demo.domain;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
	
	   @Override
	    public void configure(WebSecurity web) throws Exception
	    {
	        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
	        web.ignoring().antMatchers("/css/**", "/scripts/**", "/images/**", "/fonts/**", "/plugin/**", "/vendor/**" );
	        web.ignoring().antMatchers("/signin");
	    }
    
	   @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.antMatcher("/**")
	                .authorizeRequests()
	                .antMatchers("/", "/favicon.ico", "/login**", "/signup**", "/register**", "/main**").permitAll()
	                .anyRequest().authenticated()
	                .and().logout().logoutSuccessUrl("/").permitAll()
	                .and().headers().frameOptions().sameOrigin()
	                .and().csrf().disable();
	    }
}
