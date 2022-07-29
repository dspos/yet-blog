package com.yet.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Ekko
 *
 * @date 2022/4/9 20:05
 *
 * @description TagBackDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagBackDto {

    private Integer id;

    private String tagName;

    private Long articleCount;

    private Date createTime;
}
