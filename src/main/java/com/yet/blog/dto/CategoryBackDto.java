package com.yet.blog.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Ekko
 * @date 2022/4/13 0:11
 * @description 后台分类Dto
 */
@Schema(name = "CategoryBackDto", description = "后台分类Dto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryBackDto {

    private Integer id;

    private String categoryName;

    private Long articleCount;

    private LocalDateTime createTime;
}
