package com.yet.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author: Ekko
 * @create: 2022/07/29
 * @description: ArticleVO
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVO {

    private Integer id;

    @NotBlank(message = "articleTitle can not be null")
    private String articleTitle;

    @NotBlank(message = "articleContent can not be null")
    private String articleContent;

    private String articleCover;

    private String categoryName;

    private List<String> tagNameList;

    private Integer type;

    private String originalUrl;

    private Integer isDelete;

    private Integer isTop;

    private Integer status;


}
