package cn.wickson.tech.collective.common.constant;

/**
 * 通用常量信息
 */
public interface Constants {

    /**
     * 自动识别json对象白名单配置（仅允许解析的包名，范围越小越安全）
     */
    String[] JSON_WHITELIST_STR = {"org.springframework", "cn.wickson"};


}