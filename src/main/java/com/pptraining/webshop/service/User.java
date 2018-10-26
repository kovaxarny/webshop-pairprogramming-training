package com.pptraining.webshop.service;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
@Entity
@Table(name = "user")
public class User {

    private enum UserRole{
        USER,
        MANAGER,
        ADMIN
    }

    @Id
    @Setter(AccessLevel.PRIVATE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false, length = 32)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.USER;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", length = 24)
    private String phoneNumber;

    @OneToOne(targetEntity = UserAddress.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserAddress address;

    @Column(updatable = false)
    private LocalDateTime creationDate;
}
