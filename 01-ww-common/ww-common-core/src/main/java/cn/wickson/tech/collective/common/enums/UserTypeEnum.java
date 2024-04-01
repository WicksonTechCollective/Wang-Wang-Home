package cn.wickson.tech.collective.common.enums;

import cn.hutool.core.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 全局用户类型枚举
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum implements IntArrayValuable {

    /**
     * 第三方用户：小程序
     */
    MEMBER(1, "会员"),
    /**
     * 后台管理员用户
     */
    ADMIN(2, "管理员");

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(UserTypeEnum::getValue).toArray();

    /**
     * 类型
     */
    private final Integer value;

    /**
     * 名称
     */
    private final String name;

    /**
     * 据键返回枚举-枚举类值
     *
     * @param value 键值
     * @return
     */
    public static UserTypeEnum valueOf(Integer value) {
        return ArrayUtil.firstMatch(userType -> userType.getValue().equals(value), UserTypeEnum.values());
    }

    @Override
    public int[] array() {
        return ARRAYS;
    }
}
