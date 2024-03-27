package cn.wickson.tech.collective.auth.service;

import cn.wickson.tech.collective.auth.model.vo.CaptchaImageRespVO;

/**
 * 验证码-业务类
 *
 * @author ZhangZiHeng
 * @date 2024-03-27
 */
public interface ICaptchaService {

    /**
     * 获取验证码
     *
     * @return CaptchaImageRespVO
     */
    CaptchaImageRespVO getCaptchaImage();

}
