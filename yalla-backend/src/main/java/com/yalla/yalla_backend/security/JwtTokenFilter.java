package com.yalla.yalla_backend.security;



//setting up token filters for security

import com.yalla.yalla_backend.interfaces.AppUserDetails;
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
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

//This class is for making sure server requests have a JWT
//thanks to Ben Petruzziello (github.com/benp3837) for the utility class

//this class is a filter that runs for every http request and checks if the incoming request has a valid JWT
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
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        //If the header doesnt contain a bearer token
        //run the filter without doing anything else (request will be failed later if JWT needed)
        if (!hasAuthorizationBearer(request)){
            filterChain.doFilter(request, response);
            return;
        }



    }

    //this method extracts user details from JWT token (including authorities)
    //it then creates an auth object with these details and sets it in the security context
    //this allows spring to determine who the user is and what privileges they have
    private void setAuthenticationContext(String token, HttpServletRequest request){
        //TODO: Figure out how to adapt this to work for both users and vendors]
        //TODO: Add a discriminator for user/vendor with a polymorphic getUserDetails function
        //!! This SHOULD work for both users and vendors
        AppUserDetails user = getUserDetails(token);

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole()));

        //token already authenticates credentials, so we can use null here for creds
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                user,
                null,
                authorities
        );

        //this sets the info in the auth token
        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        //tell spring who the user is and what their role is
        //this gets stored in the auth object above
        SecurityContextHolder.getContext().setAuthentication(auth);
    }


    //method for checking auth header in http requests to see if they have JWT
    private boolean hasAuthorizationBearer(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        if (ObjectUtils.isEmpty(authorization) || !authorization.startsWith("Bearer ")){
            return false;
        }
        return true;
    }

    //method for extracting JWT from header
    //this has to occur before we can actually check the header
    private String getAccessToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        //auth header looks like this: "Bearer: {your.jwt.here}"
        //this splits along whitespace, then selects the second part of the array -- the part after Bearer:
        //the last part trims off any extra whitespace
        String token = header.split(" ")[1].trim();
        return token;
    }



    //using the interface so this works for both users and vendors
    private AppUserDetails getUserDetails(String token){
        User userDetails = new User();

        //use the extractor methods we wrote in JwtTokenUtil to get the userId and username
        userDetails.setUserId(jwtUtil.extractUserId(token));
        userDetails.setUsername(jwtUtil.extractUsername(token));
        userDetails.setRole(jwtUtil.extractRole(token));

        return userDetails;
    }

}
