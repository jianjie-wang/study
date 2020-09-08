package com.example.study.service;//package com.wjj.study.service;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @program: study
// * @description:
// * @author: WangJJ
// * @create: 2020-07-04 14:31
// **/
//@Configuration
//@EnableSwagger2
//public class Swagger {
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.itguang.springbootswaggerdemo1.web"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("swagger构建api文档标题")
//                .description("swagger文档描述")
//                .termsOfServiceUrl("http://blog.csdn.net/itguangit")
//                .version("2.0")
//                .build();
//    }
//}
