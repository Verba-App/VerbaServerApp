package ru.nsu.ccfit.verba.verbaauth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.verba.verbaauth.dto.AuthRequestDto;
import ru.nsu.ccfit.verba.verbaauth.dto.RegisterDto;
import ru.nsu.ccfit.verba.verbaauth.dto.Response;
import ru.nsu.ccfit.verba.verbaauth.entity.UserCredential;
import ru.nsu.ccfit.verba.verbaauth.exception.impl.InvalidAccessException;
import ru.nsu.ccfit.verba.verbaauth.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public Response<Void> addNewUser(@RequestBody RegisterDto request) {
        UserCredential user = new UserCredential();
        user.setName(request.getUsername());
        user.setEmail(request.getEmail());
        user.setRegion("US");
        user.setPassword(request.getPassword());
        service.saveUser(user);
        return Response.withoutErrors();
    }

    @PostMapping("/token")
    public Response<String> getToken(@RequestBody AuthRequestDto request) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        if (authenticate.isAuthenticated()) {
            return Response.withData(service.generateToken(service.getUserByName(authenticate.getName())));
        } else {
            throw new InvalidAccessException("User " + request + " invalid auth");
        }
    }

    @PostMapping("/authenticate")
    public Response<Void> validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return Response.withoutErrors();
    }
}