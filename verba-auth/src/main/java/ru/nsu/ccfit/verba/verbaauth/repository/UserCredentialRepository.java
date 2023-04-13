package ru.nsu.ccfit.verba.verbaauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.verba.verbaauth.entity.UserCredential;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential,Long> {
    Optional<UserCredential> findByName(String username);
}
