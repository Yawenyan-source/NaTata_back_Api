package com.wen.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回对象
 *
 * @author wen
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
     * @param message 返回的消息
     * @return 返回成功通用返回对象只有消息
     */
    public static RespEntity success(String message) {
        return new RespEntity(200, message, null);
    }

    /**
     * 成功返回结果
     *
     * @param message 成功返回的消息
     * @param obj     成功返回的对象数据
     * @return 返回成功通用返回对象 (消息+对象)
     */
    public static RespEntity success(String message, Object obj) {
        return new RespEntity(200, message, obj);
    }

    /**
     * 失败返回结果
     *
     * @param message 返回的消息
     * @return 返回失败后的通用返回对象--消息
     */
    public static RespEntity error(String message) {
        return new RespEntity(500, message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 返回的消息
     * @param obj     失败返回的对象数据
     * @return 返回失败后的通用返回对象 --消息+对象
     */
    public static RespEntity error(String message, Object obj) {
        return new RespEntity(500, message, obj);
    }
}
