package com.ladera.project.jpamappings.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;

}
