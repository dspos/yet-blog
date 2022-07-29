package com.yet.blog.service;

import com.yet.blog.dto.TagBackDto;
import com.yet.blog.dto.TagDto;
import com.yet.blog.result.PageResult;
import com.yet.blog.vo.TagVO;

import java.util.List;

/**
 * @author Ekko
 *
 * @date 2022/4/9 20:03
 *
 * @description TagService
 */
public interface TagService {

    /**
     * 查询后台标签列表
     *
     * @param page
     *            page
     * @param size
     *            size
     *
     * @return {@link List<TagBackDto>} 标签列表
     */
    PageResult<TagBackDto> listBackTags(Integer page, Integer size);

    /**
     * 查询标签列表
     *
     * @param page
     *            page
     * @param size
     *            size
     *
     * @return {@link List<TagDto>} 标签列表
     */
    PageResult<TagDto> listTags(Integer page, Integer size);

    /**
     * 添加或修改标签
     *
     * @param tagVo
     *            tagVo
     */
    void saveOrUpdateTag(TagVO tagVo);

    /**
     * 删除标签
     *
     * @param ids
     *            ids
     */
    void deleteAllById(List<Integer> ids);
}
