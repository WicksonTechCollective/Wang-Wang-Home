package cn.wickson.tech.collective.common.result;

import cn.wickson.tech.collective.common.constant.GlobalResultCodeConstants;
import cn.wickson.tech.collective.common.enums.ResultCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 前端统一返回结果类
 *
 * @author ZhangZiHeng
 * @date 2023-12-27
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态码描述
     */
    private String message;

    /**
     * 数据返回主体
     */
    private Object data;

    /**
     * 操作成功-无数据主体返回
     *
     * @return 返回Result类实例
     */
    public static ResultUtil success() {
        return getInstance(GlobalResultCodeConstants.SUCCESS);
    }

    /**
     * 操作成功-有数据主体返回
     *
     * @return 返回Result类实例
     */
    public static ResultUtil success(Object data) {
        return getInstance(GlobalResultCodeConstants.SUCCESS, data);
    }

    /**
     * 操作成功-有数据主体返回
     *
     * @return 返回Result类实例
     */
    public static ResultUtil success(Integer code, String message) {
        return getInstance(code, message);
    }

    /**
     * 操作失败-无数据主体返回
     *
     * @return 返回Result类实例
     */
    public static ResultUtil failure(ResultCode code) {
        return getInstance(code);
    }

    /**
     * 操作失败-有数据主体返回
     *
     * @return 返回Result类实例
     */
    public static ResultUtil failure(ResultCode code, String message) {
        return getInstance(code, message);
    }

    /**
     * 操作失败-有数据主体返回
     *
     * @return 返回Result类实例
     */
    public static ResultUtil failure(ResultCode code, Object data) {
        return getInstance(code, data);
    }

    /**
     * 操作成功-有数据主体返回
     *
     * @return 返回Result类实例
     */
    public static ResultUtil failure(Integer code, String message) {
        return getInstance(code, message);
    }

    /**
     * 获取Result类实例
     *
     * @return 返回Result类实例
     */
    private static ResultUtil getInstance(ResultCode code) {
        return getInstance(code.getCode(), code.getMsg(),null);
    }

    /**
     * 获取Result类实例
     *
     * @return 返回Result类实例
     */
    private static ResultUtil getInstance(ResultCode code, String message) {
        return getInstance(code.getCode(), message,null);
    }

    /**
     * 获取Result类实例
     *
     * @return 返回Result类实例
     */
    private static ResultUtil getInstance(ResultCode code, Object data) {
        return getInstance(code.getCode(), code.getMsg(), data);
    }

    /**
     * 获取空值Result类实例
     *
     * @param code
     * @param message
     * @return
     */
    private static ResultUtil getInstance(Integer code, String message) {
        ResultUtil result = ResultUtil.getInstance();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    /**
     * 获取空值Result类实例
     *
     * @param code
     * @param message
     * @param data
     * @return
     */
    private static ResultUtil getInstance(Integer code, String message, Object data) {
        ResultUtil result = ResultUtil.getInstance();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 获取空值Result类实例
     *
     * @return
     */
    private static ResultUtil getInstance() {
        return new ResultUtil();
    }

}
