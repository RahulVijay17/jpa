package com.ladera.project.jpamappings.service.impl;

import com.ladera.project.jpamappings.vo.*;

import com.ladera.project.jpamappings.mapper.AllEntityMapper;
import com.ladera.project.jpamappings.model.Cart;
import com.ladera.project.jpamappings.model.Product;
import com.ladera.project.jpamappings.model.User;
import com.ladera.project.jpamappings.repository.CartRepository;
import com.ladera.project.jpamappings.repository.ProductRepository;
import com.ladera.project.jpamappings.repository.UserRepository;
import com.ladera.project.jpamappings.service.CartProductUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartProductUserServiceImpl implements CartProductUserService {
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private AllEntityMapper allEntityMapper;

    @Override
    public ProductCartUserVo createCartProductUser(ProductCartUserVo productCartUserVo) {

        User user = allEntityMapper.toUserEntity(productCartUserVo.getUserVo());
        user = userRepository.save(user);
        UserVo userVo = allEntityMapper.toUserVo(user);
        productCartUserVo.setUserVo(userVo);

        Product product = allEntityMapper.toProductEntity(productCartUserVo.getProductVo());
        product = productRepository.save(product);
        ProductVo productVo = allEntityMapper.toProductVo(product);

        Cart cart = allEntityMapper.toCartEntity(productCartUserVo.getCartVo());
        cart.setUser(user);
        cart.setProduct(product);
        cart = cartRepository.save(cart);
        CartVo cartVo = allEntityMapper.toCartVo(cart);

        ProductCartUserVo productCartUserVo1 = new ProductCartUserVo();
        productCartUserVo1.setUserVo(userVo);
        productCartUserVo1.setProductVo(productVo);
        productCartUserVo1.setCartVo(cartVo);
        return productCartUserVo1;
      }

    @Override
    public List<ProductVo> getAllProductsByCartId(Long cartId) {
        List<Cart> cartList = cartRepository.findByCartId(cartId);
        return cartList.stream()
                .map(cart -> allEntityMapper.toProductVo(cart.getProduct()))
                .collect(Collectors.toList());
    }

    @Override
    public UserVo findUserByCartId(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            throw new IllegalArgumentException("Cart ID not found: " + cartId);
        }
        User user = cart.getUser();
        return allEntityMapper.toUserVo(user);
    }

    @Override
    public List<ProductVo> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(allEntityMapper::toProductVo)
                .collect(Collectors.toList());
    }

    @Override
    public ProductVo getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return allEntityMapper.toProductVo(product.get());
        }
        return null;
    }
    @Override
    public List<CartVo> getAllCartsByProductId(Long productId) {
        List<Cart> cartList = productRepository.findCartsByProductId(productId);
        return cartList.stream()
                .map(allEntityMapper::toCartVo)
                .collect(Collectors.toList());
    }

}