package com.yet.blog.controller;

import com.yet.blog.annotation.OptLog;
import com.yet.blog.dto.TagBackDto;
import com.yet.blog.dto.TagDto;
import com.yet.blog.result.PageResult;
import com.yet.blog.result.Result;
import com.yet.blog.service.TagService;
import com.yet.blog.vo.TagVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.yet.blog.constant.OptTypeConst.DELETE;
import static com.yet.blog.constant.OptTypeConst.QUERY;
import static com.yet.blog.constant.OptTypeConst.SAVE_OR_UPDATE;

/**
 * @author Ekko
 * @date 2022/4/9 20:01
 * @description 标签Controller
 */
@Tag(name = "标签", description = "标签接口")
@RestController
@RequestMapping("api")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @Operation(summary = "查询标签列表", description = "查询标签列表")
    @OptLog(optType = QUERY)
    @GetMapping("tags/{page}/{size}")
    public Result<PageResult<TagDto>> listTags(
            @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return Result.ok(tagService.listTags(page, size));
    }

    @Operation(summary = "查询后台标签列表", description = "查询后台标签列表")
    // @OptLog(optType = QUERY)
    @GetMapping("admin/tags/{page}/{size}")
    public Result<PageResult<TagBackDto>> listBackTags(
            @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return Result.ok(tagService.listBackTags(page, size));
    }

    @Operation(summary = "新增或修改标签", description = "新增或修改标签")
    @OptLog(optType = SAVE_OR_UPDATE)
    @PostMapping("admin/tag")
    public Result<Void> saveOrUpdateTag(@Valid @RequestBody TagVO tagVo) {
        tagService.saveOrUpdateTag(tagVo);
        return Result.ok();
    }

    @Operation(summary = "批量删除标签", description = "批量删除标签")
    @OptLog(optType = DELETE)
    @DeleteMapping("admin/tag")
    public Result<Void> deleteAllById(@RequestBody List<Integer> ids) {
        tagService.deleteAllById(ids);
        return Result.ok();
    }
}
