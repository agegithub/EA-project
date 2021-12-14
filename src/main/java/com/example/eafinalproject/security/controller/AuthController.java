package com.example.eafinalproject.security.controller;
import com.example.eafinalproject.security.jwt.JwtUtil;
import com.example.eafinalproject.security.model.AuthenticationRequest;
import com.example.eafinalproject.security.model.AuthenticationResponse;
import com.example.eafinalproject.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("api/auth")
//@Tag(name = "Authentication")
    class AuthController {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private JwtUtil jwtTokenUtil;

        @Autowired
        private UserService userDetailsService;

        @PostMapping("/login")
        public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

            System.out.println(authenticationRequest);

            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
                );
            }
            catch (BadCredentialsException e) {
                throw new Exception("Incorrect username or password", e);
            }


            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(token));
        }
}
