package com.wen.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespEntity {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     *
     * @param message
     * @return
     */
    public static RespEntity success(String message) {
        return new RespEntity(200, message, null);
    }

    /**
     * 成功返回结果
     *
     * @param message
     * @param obj
     * @return
     */
    public static RespEntity success(String message, Object obj) {
        return new RespEntity(200, message, obj);
    }

    /**
     * 失败返回结果
     *
     * @param message
     * @return
     */
    public static RespEntity error(String message) {
        return new RespEntity(500, message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message
     * @param obj
     * @return
     */
    public static RespEntity error(String message, Object obj) {
        return new RespEntity(500, message, obj);
    }
}
