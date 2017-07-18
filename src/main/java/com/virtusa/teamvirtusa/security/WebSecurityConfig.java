package com.virtusa.teamvirtusa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/helloWorld").permitAll()
                .antMatchers("/createTeam").permitAll()
                .antMatchers("/checkDuplicateEmail/**").permitAll()
                .antMatchers("/getTeamDetails/**").permitAll()
                .antMatchers("/checkDuplicateTeam/**").permitAll()
                .antMatchers("/timeTest/**").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/login").permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/configuration/**").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                // Filter the api/login requests
                .addFilterBefore(new JwtLoginFilter("/login",authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore(new JwtAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password, enabled from party_login where username=?")
    	.authoritiesByUsernameQuery("SELECT party_login.username AS username, role.role_name AS authority FROM party_login_role INNER JOIN party_login ON party_login_role.party_login_id=party_login.party_login_id INNER JOIN role ON party_login_role.role_id=role.role_id WHERE party_login.username=?");
    }*/
}