package ru.nsu.ccfit.verba.verbaauth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.verba.verbaauth.entity.UserCredential;
import ru.nsu.ccfit.verba.verbaauth.repository.UserCredentialRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserCredentialRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        repository.save(credential);
        return "user added to the system";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
