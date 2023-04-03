package com.ladera.project.jpamappings.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartVo {
    private Long cartId;
    private Integer cartQuantity;
    private Long userId;
    private Long productId;

}
