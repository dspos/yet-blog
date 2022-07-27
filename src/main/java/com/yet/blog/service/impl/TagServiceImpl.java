package com.yet.blog.service.impl;

import com.yet.blog.dto.TagBackDto;
import com.yet.blog.dto.TagDto;
import com.yet.blog.entity.TagEntity;
import com.yet.blog.exception.BusinessException;
import com.yet.blog.repository.TagRepository;
import com.yet.blog.result.PageResult;
import com.yet.blog.service.TagService;
import com.yet.blog.util.BeanCopyUtil;
import com.yet.blog.vo.TagVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ekko
 * @date 2022/4/9 20:03
 * @description TagServiceImpl
 */
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public PageResult<TagBackDto> listBackTags(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        List<TagBackDto> tagBackDtoList = tagRepository.listTagBackDto(pageable);
        Integer count = Math.toIntExact(tagRepository.count());
        return new PageResult<>(tagBackDtoList, count);
    }

    @Override
    public PageResult<TagDto> listTags(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        List<TagEntity> tagList = tagRepository.findAll(pageable).getContent();
        List<TagDto> tagDtoList = BeanCopyUtil.copyBeanList(tagList, TagDto.class);
        Integer count = Math.toIntExact(tagRepository.count());
        return new PageResult<>(tagDtoList, count);
    }

    @Override
    public void saveOrUpdateTag(TagVO tagVo) {
        TagEntity tag = new TagEntity();
        TagEntity exist = tagRepository.findOneByTagName(tagVo.getTagName());
        if (exist != null) {
            throw new BusinessException("标签已存在");
        }
        BeanUtils.copyProperties(tagVo, tag);
        tagRepository.save(tag);
    }


    @Override
    public void deleteAllById(List<Integer> ids) {
        tagRepository.deleteAllById(ids);
    }
}
