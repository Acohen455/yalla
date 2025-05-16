package com.yalla.yalla_backend.security;



//setting up token filters for security

import com.yalla.yalla_backend.models.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

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

    //this method extracts user details from JWT token (including authorities)
    //it then creates an auth object with these details and sets it in the security context
    //this allows spring to determine who the user is and what privileges they have
    private void setAuthenticationContext(String token, HttpServletRequest request){
        //TODO: Figure out how to adapt this to work for both users and vendors
        //for now making a user only mockup
        User user = (User) getUserDetails(token);

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole()));

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                user,
                null,
                authorities
        );

        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        //tell spring who the user is and what their role is
        //this gets stored in the auth object above
        SecurityContextHolder.getContext().setAuthentication(auth);
    }


    private UserDetails getUserDetails(String token){
        User userDetails = new User();

        //use the extractor methods we wrote in JwtTokenUtil to get the userId and username
        userDetails.setUserId(jwtUtil.extractUserId(token));
        userDetails.setUsername(jwtUtil.extractUsername(token));
        userDetails.setRole(jwtUtil.extractRole(token));

        return userDetails;

    }

}
