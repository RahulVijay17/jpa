package com.ladera.project.jpamappings.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCartUserVo {
    private CartVo cartVo;
    private ProductVo productVo;
    private UserVo userVo;

}
