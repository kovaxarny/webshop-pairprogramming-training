package com.pptraining.webshop.service;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
@Getter
@Setter
@Entity
@Table(name = "user_address")
public class UserAddressDO {
    @Id
    @Setter(AccessLevel.PRIVATE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zip_code", length = 16)
    private String zipCode;

    @Column(length = 32)
    private String country;

    @Column(length = 32)
    private String city;

    @Column(length = 32)
    private String street;

    @Column(name = "house_number", length = 32)
    private String houseNumber;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private UserDO user;
}
