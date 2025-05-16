package com.yalla.yalla_backend.security;



//setting up token filters for security

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//This class is for making sure server requests have a JWT

//this class is a filter that runs for ever http request and checks if the incoming request has a valid JWT
@Component //onceperrequest filter makes it execute a single time per request
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtUtil;

    //inject the dependencies
    @Autowired
    public JwtTokenFilter(JwtTokenUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /* This method gets called when requests come in, and checks if the request has a valid JWT in the header.*/
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //If the header doesnt contain a bearer token
        //run the filter without doing anything else (request will be failed later if JWT needed)


    }

}
