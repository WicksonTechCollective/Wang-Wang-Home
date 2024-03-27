package cn.wickson.tech.collective.auth.constant;

/**
 * 验证码参数信息
 *
 * @author ZhangZiHeng
 * @date 2024-03-27
 */
public interface CaptchaConstants {

    /**
     * 验证码宽
     */
    Integer CAPTCHA_WIDTH = 120; // 、高、位数

    /**
     * 验证码高
     */
    Integer CAPTCHA_HEIGHT = 40;

    /**
     * 验证码位数
     */
    Integer CAPTCHA_COUNT = 4;

    /**
     * 验证码超时时间
     */
    Integer CAPTCHA_TIME_OUT = 60;

}
