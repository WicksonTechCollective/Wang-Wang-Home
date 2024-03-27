package cn.wickson.tech.collective.auth.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.core.lang.UUID;
import cn.wickson.tech.collective.auth.constant.CaptchaConstants;
import cn.wickson.tech.collective.auth.service.ICaptchaService;
import cn.wickson.tech.collective.auth.model.vo.CaptchaImageRespVO;
import cn.wickson.tech.collective.common.constant.CacheConstants;
import cn.wickson.tech.collective.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 验证码-业务实现类
 *
 * @author ZhangZiHeng
 * @date 2024-03-27
 */
@Service
public class CaptchaServiceImpl implements ICaptchaService {

    @Value("${captcha.enable}")
    private Boolean enable;

    @Resource
    private RedisService redisService;

    @Override
    public CaptchaImageRespVO getCaptchaImage() {
        /* Step-1：判断是否开启验证码 */
        if (!enable) {
            return CaptchaImageRespVO.builder().enable(enable).build();
        }

        /* Step-2: 生成验证码信息 */
        GifCaptcha captcha =
                CaptchaUtil.createGifCaptcha(CaptchaConstants.CAPTCHA_WIDTH, CaptchaConstants.CAPTCHA_HEIGHT, CaptchaConstants.CAPTCHA_COUNT);

        /* Step-3: 将验证码存入redis */
        String code = UUID.fastUUID().toString();
        String codeKey = getCaptchaCodeKey(code);
        redisService.setCacheObject(codeKey, captcha.getCode(), CaptchaConstants.CAPTCHA_TIME_OUT, TimeUnit.SECONDS);

        /* Step-4: 返回结果集 */
        return CaptchaImageRespVO.builder().enable(enable).code(code).images(captcha.getImageBase64()).build();
    }

    /**
     * 获取验证码索引 Key
     *
     * @param key key
     * @return String
     */
    private String getCaptchaCodeKey(String key) {
        return String.format(CacheConstants.CAPTCHA_CODE_KEY, key);
    }


}
