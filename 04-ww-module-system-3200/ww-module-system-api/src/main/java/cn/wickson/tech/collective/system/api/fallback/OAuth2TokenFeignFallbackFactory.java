package cn.wickson.tech.collective.system.api.fallback;

import cn.wickson.tech.collective.system.api.SystemOAuth2TokenApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author ZhangZiHeng
 * @date 2024-03-31
 */
@Slf4j
@Component
public class OAuth2TokenFeignFallbackFactory implements FallbackFactory<SystemOAuth2TokenApi>  {

    @Override
    public SystemOAuth2TokenApi create(Throwable cause) {
        return new SystemOAuth2TokenApi() {

            @Override
            public CommonResult<OAuth2AccessTokenRespDTO> createAccessToken(OAuth2AccessTokenCreateReqDTO reqDTO) {
                return null;
            }
        };
    }

}
