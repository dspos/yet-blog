package com.yet.blog.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ekko
 * @date 2022/4/10 21:35
 * @description CategoryDto
 */
@Schema(name = "CategoryDto", description = "分类Dto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Integer id;

    private String categoryName;

    private Integer articleCount;
}
