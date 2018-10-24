package com.pptraining.webshop.service;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "product")
public class ProductDO {

    @Id
    @Setter(AccessLevel.PRIVATE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(nullable = false, length = 64)
    private String producer;

    @Column(precision = 2)
    private double price;

    @OneToOne(targetEntity = ProductDetails.class, fetch = FetchType.LAZY)
    private ProductDetails productDetails;

    @Lob
    @Column
    private byte[] picture;

}
