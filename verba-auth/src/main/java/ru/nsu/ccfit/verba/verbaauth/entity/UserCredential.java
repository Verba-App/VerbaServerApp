package ru.nsu.ccfit.verba.verbaauth.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "verba_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String region;
    private String password;
}