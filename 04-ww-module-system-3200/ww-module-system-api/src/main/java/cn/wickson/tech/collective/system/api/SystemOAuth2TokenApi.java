package cn.wickson.tech.collective.system.api;

import cn.wickson.tech.collective.common.result.ResultUtil;
import cn.wickson.tech.collective.common.web.config.FeignConfig;
import cn.wickson.tech.collective.system.api.fallback.OAuth2TokenFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 创建 OAuth2
 *
 * @author ZhangZiHeng
 * @date 2024-03-31
 */
@FeignClient(value = "wang-wang-home-system", fallbackFactory = OAuth2TokenFeignFallbackFactory.class, configuration = FeignConfig.class)
public interface SystemOAuth2TokenApi {

    @PostMapping( "/system/create")
    ResultUtil<OAuth2AccessTokenRespDTO> createAccessToken(@Valid @RequestBody OAuth2AccessTokenCreateReqDTO reqDTO);

}
