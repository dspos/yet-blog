package com.yet.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Ekko
 * @date 2022/4/15 17:24
 * @description ArticleHomeDtoTemp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleHomeDtoTemp {
    private Integer id;

    private String articleCover;

    private String articleTitle;

    private String articleContent;

    private Date createTime;

    private Integer isTop;

    private Integer type;

    private Integer categoryId;

    private String categoryName;

    private Integer tagId;

    private String tagName;
}
