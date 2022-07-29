package com.yet.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Ekko
 * @date 2022/4/13 23:29
 * @description ArchiveDto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveDto {

    private Integer id;

    private String articleTitle;

    private LocalDateTime createTime;
}
