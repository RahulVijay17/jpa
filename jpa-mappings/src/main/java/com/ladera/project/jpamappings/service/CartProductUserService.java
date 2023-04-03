package com.ladera.project.jpamappings.service;

import com.ladera.project.jpamappings.vo.*;

import java.util.List;

public interface CartProductUserService {

    ProductCartUserVo createCartProductUser(ProductCartUserVo productCartUserVo);
    List<ProductVo> getAllProductsByCartId(Long cartId);
    UserVo findUserByCartId(Long cartId);
    List<ProductVo> getAllProducts();
    ProductVo getProductById(Long id);

/*
    List<CartDto> getAllCartsByProductId(Long productId);
*/
    List<CartVo> getAllCartsByProductId(Long productId);
}
