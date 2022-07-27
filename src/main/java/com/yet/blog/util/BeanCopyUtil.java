package com.yet.blog.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Ekko
 * @date 2022/4/10 0:13
 * @description BeanCopyUtil
 */
public class BeanCopyUtil {

  public static <T> List<T> copyBeanList(List<?> sourceList, Class<T> targetClass) {
    List<T> targetList = new ArrayList<>();
    if (sourceList == null || sourceList.size() == 0) {
      return targetList;
    }
    sourceList.forEach(
        source -> {
          T o = null;
          try {
            o = targetClass.getDeclaredConstructor().newInstance();
          } catch (InstantiationException
              | IllegalAccessException
              | InvocationTargetException
              | NoSuchMethodException e) {
            e.printStackTrace();
          }
          BeanUtils.copyProperties(source, Objects.requireNonNull(o));
          targetList.add(o);
        });
    return targetList;
  }
}
