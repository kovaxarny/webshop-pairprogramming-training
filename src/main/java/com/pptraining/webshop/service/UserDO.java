package com.pptraining.webshop.service;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
@Entity
@Table(name = "user")
public class UserDO {
    @Id
    @Setter(AccessLevel.PRIVATE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false, length = 32)
    private String username;

    @Column(name = "first_name", length = 32, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 32, nullable = false)
    private String lastName;

    @Email
    @Column(length = 64, nullable = false)
    private String email;

    @Column(name = "phone_number", length = 24)
    private String phoneNumber;

    @OneToOne(targetEntity = UserAddressDO.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserAddressDO address;
}
