package com.ladera.project.jpamappings.mapper.impl;


import com.ladera.project.jpamappings.vo.CartVo;
import com.ladera.project.jpamappings.vo.ProductVo;
import com.ladera.project.jpamappings.vo.UserVo;
import com.ladera.project.jpamappings.mapper.AllEntityMapper;
import com.ladera.project.jpamappings.model.Cart;
import com.ladera.project.jpamappings.model.Product;
import com.ladera.project.jpamappings.model.User;
import org.springframework.stereotype.Service;

@Service
public class AllEntityMapperImpl implements AllEntityMapper {

    @Override
    public User toUserEntity(UserVo userVo) {
        User user = new User();
        user.setUserName(userVo.getUserName());
        user.setUserEmail(userVo.getUserEmail());
        user.setUserPassword(userVo.getUserPassword());
        return user;
    }

    @Override
    public UserVo toUserVo(User user) {
        UserVo userVo = new UserVo();
        userVo.setUserId(user.getUserId());
        userVo.setUserName(user.getUserName());
        userVo.setUserEmail(user.getUserEmail());
        userVo.setUserPassword(user.getUserPassword());
        return userVo;
    }

    @Override
    public CartVo toCartVo(Cart cart) {
        if (cart == null) {
            return null;
        }
        CartVo cartVo = new CartVo();
        cartVo.setCartId(cart.getCartId());
        cartVo.setCartQuantity(cart.getCartQuantity());
        cartVo.setUserId(cart.getUser().getUserId());
        cartVo.setProductId(cart.getProduct().getProductId());
        return cartVo;
    }

    @Override
    public Cart toCartEntity(CartVo cartVo) {
        if (cartVo == null) {
            return null;
        }
        Cart cart = new Cart();
        cart.setCartId(cartVo.getCartId());
        cart.setCartQuantity(cartVo.getCartQuantity());
        return cart;
    }

    @Override
    public Product toProductEntity(ProductVo productVo) {
        Product product = new Product();
        product.setProductId(productVo.getProductId());
        product.setProductName(productVo.getProductName());
        product.setProductPrice(productVo.getProductPrice());
        return product;
    }

    @Override
    public ProductVo toProductVo(Product product) {
        ProductVo productVo = new ProductVo();
        productVo.setProductId(product.getProductId());
        productVo.setProductName(product.getProductName());
        productVo.setProductPrice(product.getProductPrice());
        return productVo;
    }
}
