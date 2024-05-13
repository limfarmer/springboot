package com.kh.mini.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors
public class MemberVo {
    private String id;
    private String pwd;
    private String email;
    private String name;
    private Date join;
}
