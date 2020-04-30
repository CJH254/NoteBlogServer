package gupt.cjh.noteblog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.DocumentType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description:
 * @Author 二维世界是个圆
 * @Date 2020/4/30
 * @Version V1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Swagger常用注解
     * <p>
     * 作用范围                      API                 使用位置
     * 协议集描述	                @Api	            用于 Controller 类上
     * 协议描述	                    @ApiOperation       用在 Controller 的方法上
     * 非对象参数集	                @ApiImplicitParams	用在 Controller 的方法上
     * 非对象参数描述	                @ApiImplicitParam	用在 @ApiImplicitParams 的方法里边
     * 响应集	                    @ApiResponses	    用在 Controller 的方法上
     * 响应信息参数	                @ApiResponse	    用在 @ApiResponses 里边
     * 描述返回对象的意义             @ApiModel	        用在返回对象类上
     * 对象属性	                    @ApiModelProperty	用在出入参数对象的字段上
     */

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("gupt.cjh.noteblog.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("江东父老小组 - 博客项目Api")
                .description("这是博客项目后端代码的Api文档")
                .version("1.0")
                .build();
    }

}
