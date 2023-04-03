package com.ladera.project.jpamappings.repository;

import com.ladera.project.jpamappings.model.Cart;
import com.ladera.project.jpamappings.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT c FROM Cart c WHERE c.product.id = :productId")
    List<Cart> findCartsByProductId(@Param("productId") Long productId);
}
