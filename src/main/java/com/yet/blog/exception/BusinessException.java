package com.yet.blog.exception;

import com.yet.blog.constant.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.yet.blog.constant.StatusCodeEnum.FAIL;

/**
 * @author Ekko
 * @date 2022/4/10 2:26
 * @description BusinessException
 */
@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code = FAIL.getCode();

    /**
     * 错误信息
     */
    private final String message;

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getDesc();
    }
}
