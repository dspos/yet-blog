package com.yet.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * 分类VO
 *
 * @author yezhiqiu
 *
 * @date 2021/07/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO {

    private Integer id;

    @NotBlank(message = "分类名称不能为空")
    private String categoryName;

}
