package com.ladera.project.jpamappings.mapper;

import com.ladera.project.jpamappings.vo.CartVo;
import com.ladera.project.jpamappings.vo.ProductVo;
import com.ladera.project.jpamappings.vo.UserVo;
import com.ladera.project.jpamappings.model.Cart;
import com.ladera.project.jpamappings.model.Product;
import com.ladera.project.jpamappings.model.User;

public interface AllEntityMapper {
    User toUserEntity(UserVo userDto);
    UserVo toUserVo(User user);
    CartVo toCartVo(Cart cart);
    Cart toCartEntity(CartVo cartDto);
    Product toProductEntity(ProductVo productDto);
    ProductVo toProductVo(Product product);

}
