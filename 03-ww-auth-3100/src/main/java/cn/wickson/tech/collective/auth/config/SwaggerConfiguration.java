package cn.wickson.tech.collective.auth.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfiguration {

    /**
     * 是否开启swagger配置，生产环境需关闭
     */
//    @Value("${swagger.enable:true}")
//    private boolean enable;
//
//    @Value("${swagger.version:'v1.0.0'}")
//    private String version;

    @Bean
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .enable(enable)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("cn.wickson.tech.collective.auth.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Wang Wang Home")
                .description("API接口列表")
//                .version(version)
                .build();
    }

}