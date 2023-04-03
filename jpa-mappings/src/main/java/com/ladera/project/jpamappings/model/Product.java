package com.ladera.project.jpamappings.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Double productPrice;

    @OneToMany(mappedBy = "product", targetEntity = Cart.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cart> cartList = new ArrayList<>();
}