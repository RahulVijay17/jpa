package com.ladera.project.jpamappings.controller;

import com.ladera.project.jpamappings.vo.CartVo;
import com.ladera.project.jpamappings.vo.ProductCartUserVo;
import com.ladera.project.jpamappings.vo.ProductVo;
import com.ladera.project.jpamappings.vo.UserVo;
import com.ladera.project.jpamappings.service.CartProductUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartProductUserController {

    @Autowired
    private CartProductUserService cartProductUserService;

    @PostMapping("/create")
    public ResponseEntity<ProductCartUserVo> createCartProductUser(@RequestBody ProductCartUserVo productCartUserVo) {
        ProductCartUserVo savedCartProductUserVo = cartProductUserService.createCartProductUser(productCartUserVo);
        return ResponseEntity.ok(savedCartProductUserVo);
        }

    @GetMapping("/{cartId}/products")
    public ResponseEntity<List<ProductVo>> getAllProductsInCart(@PathVariable Long cartId) {
        List<ProductVo> products = cartProductUserService.getAllProductsByCartId(cartId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{cartId}/user")
    public ResponseEntity<UserVo> findUserByCartId(@PathVariable Long cartId) {
        UserVo userVo = cartProductUserService.findUserByCartId(cartId);
        return ResponseEntity.ok(userVo);
    }

    @GetMapping("/products")
    public List<ProductVo> getAllProducts() {
        return cartProductUserService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductVo> getProductById(@PathVariable Long id) {
        ProductVo productVo = cartProductUserService.getProductById(id);
        if (productVo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productVo);
    }

    @GetMapping("/product/{productId}/carts")
    public ResponseEntity<List<CartVo>> getAllCartsByProductId(@PathVariable Long productId) {
        List<CartVo> cartVoList = cartProductUserService.getAllCartsByProductId(productId);
        if (cartVoList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartVoList);
    }
}

