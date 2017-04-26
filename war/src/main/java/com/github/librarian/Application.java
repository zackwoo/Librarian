package com.github.librarian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by zack.wu on 2017/4/11.
 */
@SpringBootApplication
//启用Swagger2
@EnableSwagger2
//自动扫描包下所有mapper类
@MapperScan({"com.github.librarian.model.mapper","com.github.librarian.model.custom"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }


    //swagger2 相关配置设置
    @Bean
    public Docket reportSettingApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api/*.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RESTful API")
                .description("Spring REST Sample with Swagger")
                .contact("zack")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("1.0")
                .build();
    }
}
