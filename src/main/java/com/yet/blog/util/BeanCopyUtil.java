package com.yet.blog.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ekko
 * @date 2022/4/10 0:13
 * @description BeanCopyUtil
 */
public class BeanCopyUtil {

    public static <T> T copyObject(Object source, Class<T> target) {
        T temp;
        try {
            temp = target.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        if (null != source) {
            BeanUtils.copyProperties(source, temp);
        }
        return temp;
    }

    public static <T> List<T> copyBeanList(List<?> sourceList, Class<T> targetClass) {
        List<T> targetList = new ArrayList<>();
        if (null != sourceList && sourceList.size() > 0) {
            sourceList.forEach(source -> targetList.add(BeanCopyUtil.copyObject(source, targetClass)));
        }
        return targetList;
    }
}
