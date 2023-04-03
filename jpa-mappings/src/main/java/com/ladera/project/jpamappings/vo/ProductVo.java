package com.ladera.project.jpamappings.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductVo {
    private Long productId;
    private String productName;
    private Double productPrice;

}
