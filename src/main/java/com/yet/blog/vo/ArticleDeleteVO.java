package com.yet.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: Ekko
 * @create: 2022/07/30
 * @description:
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDeleteVO {

    @NotNull(message = "idList can not be null")
    private List<Integer> idList;

    @NotNull(message = "status code can not be null")
    private Integer isDelete;
}
