package com.virtusa.teamvirtusa.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
    	HttpServletResponse res = (HttpServletResponse)response;
    	HttpServletRequest req = (HttpServletRequest)request;
    	// Exception flow for preflight checks for non login requests
        if(((HttpServletRequest)request).getMethod().equalsIgnoreCase("OPTIONS")){
        	res.setHeader("Access-Control-Allow-Origin", "*");
        	res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        	res.setHeader("Access-Control-Allow-Headers", "X-Authorization, xsrf-token, Authorization, Content-Type, X-Requested-With, Cache-Control, postman-token");
        	return;
        }
        res.setHeader("Access-Control-Allow-Origin", "*");
        Authentication authentication = TokenAuthenticationService
                .getAuthentication(req);     
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        filterChain.doFilter(request,response);
    }
}