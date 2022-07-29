package com.yet.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Ekko
 *
 * @date 2022/4/14 15:21
 *
 * @description ArticleHomeDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleHomeDto {

    private Integer id;

    private String articleCover;

    private String articleTitle;

    private String articleContent;

    private Date createTime;

    private Integer isTop;

    private Integer type;

    private Integer categoryId;

    private String categoryName;

    private List<TagDto> tagDTOList;
}
