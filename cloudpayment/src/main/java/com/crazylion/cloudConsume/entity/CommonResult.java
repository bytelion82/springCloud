package com.crazylion.cloudConsume.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共结果类
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String  message;
    private T data;

    public CommonResult(Integer code ,String message){
        this(code,message,null);
    }
}
