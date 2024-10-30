package com.common;

/**
 * @author:qjj
 * @create: 2023-10-05 10:13
 * @Description:
 */

/**
 * 平台错误码
 *
 * @公众号：马丁玩编程，回复：加群，添加马哥微信（备注：12306）获取项目资料
 */
public interface IErrorCode {

    /**
     * 错误码
     */
    String code();

    /**
     * 错误信息
     */
    String message();
}