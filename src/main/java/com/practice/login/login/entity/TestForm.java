package com.practice.login.login.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author qinhonglin
 * @date 2018/10/26
 */
@Data
public class TestForm {

    @NotNull
    private String a;

    @NotBlank(message = "字段b不能为空")
    private String b;
    private Integer c;
}
