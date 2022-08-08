package com.yet.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ekko
 * @date 2022/4/9 20:05
 * @description TagDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDto {

    private Integer id;

    private String tagName;
}
