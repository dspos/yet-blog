package com.yet.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Ekko
 *
 * @date 2022/4/15 17:24
 *
 * @description ArticleHomeDtoTemp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleHomeDtoTemp {
    private Integer id;

    private String article_cover;

    private String article_title;

    private String article_content;

    private Date create_time;

    private Integer is_top;

    private Integer type;

    private Integer category_id;

    private String category_name;

    private Integer tag_id;

    private String tag_name;

}
