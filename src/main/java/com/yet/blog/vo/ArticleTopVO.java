package com.yet.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author: Ekko
 * @create: 2022/07/30
 * @description: ArticleTopVO
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTopVO {

    @NotNull(message = "id can not be null")
    private Integer id;

    @NotNull(message = "id can not be null")
    private Integer isTop;
}
