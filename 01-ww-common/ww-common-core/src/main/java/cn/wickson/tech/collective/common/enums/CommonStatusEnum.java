package cn.wickson.tech.collective.common.enums;

import cn.hutool.core.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通用状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum CommonStatusEnum {

    ENABLE(0, "开启"),
    DISABLE(1, "关闭");

    /**
     * 状态值
     */
    private final Integer status;
    /**
     * 状态名
     */
    private final String name;

    /**
     * 据键返回枚举-枚举类值
     *
     * @param status 键值
     * @return
     */
    public static CommonStatusEnum valueOf(Integer status) {
        return ArrayUtil.firstMatch(commonStatus -> commonStatus.getStatus().equals(status), CommonStatusEnum.values());
    }

}
