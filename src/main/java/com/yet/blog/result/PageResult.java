package com.yet.blog.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Ekko
 * @date 2022/4/10 0:23
 * @description 分页对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "分页对象")
public class PageResult<T> {
    /**
     * 分页列表
     */
    @Schema(name = "recordList", required = true)
    private List<T> recordList;

    /**
     * 总数
     */
    @Schema(name = "count", required = true)
    private Integer count;
}
