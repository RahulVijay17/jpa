package com.ladera.project.jpamappings.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private Integer cartQuantity;

    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name = "user_id",referencedColumnName = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name = "product_id",referencedColumnName = "productId")
    private Product product;

}