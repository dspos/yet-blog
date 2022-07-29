package com.yet.blog.enun;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: Ekko
 * @create: 2022/07/29
 * @description:
 **/
@Getter
@AllArgsConstructor
public enum ArticleStatusEnum {

    PUBLIC(1, "PUBLIC"),

    SECRET(2, "SECRET"),

    DRAFT(3, "DRAFT");

    private final Integer status;

    private final String desc;
}
