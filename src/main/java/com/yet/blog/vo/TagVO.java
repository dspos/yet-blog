package com.yet.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Ekko
 * @date 2022/4/12 23:32
 * @description TagVO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagVO {


    private Integer id;

    @NotBlank(message = "标签名不能为空")
    private String tagName;
}
