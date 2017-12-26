package com.lensyn.addresslist.system.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.ant;

/**
 * swagger配置,配置项来源于spring-cloud-starter-zookeeper-config
 * 配置在zookeeper节点上,具体在/configurations/microserver/hydropower-portal-service
 * 默认开启文档在开发环境
 * Created by liudp on 17-7-31.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
    @Autowired
    private Environment environment;

    @Value("${security.oauth2.client.clientId}")
    private String authClientId;        /*需要授权的应用ID*/
    @Value("${security.oauth2.client.clientSecret}")
    private String authClientSecret;    /*需要授权的应用密码*/
    @Value("${security.oauth2.client.grantType}")
    private String type;                /*授权的认证类型*/
    @Value("${security.oauth2.client.authorizationUri}")
    private String authorizationUrl;    /*oauth认证地址*/
    @Value("${security.oauth2.client.accessTokenUri}")
    private String tokenUrl;            /*oauth token地址*/
    private String tokenName = "access_token";           /*oauth token*/
    @Value("${security.oauth2.client.scope}")
    private String scopeCode;           /*认证权限*/
//    @Value("${security.oauth2.client.scopeDesc}")
//    private String scopeDesc;           /*授权应用描述*/
//    @Value("${app.key}")
//    private String appKey;              /*授权应用 key*/
//    @Value("${app.name}")
//    private String appName;             /*授权应用名称*/
//    @Value("${app.desc}")
//    private String appDesc;             /*授权应用描述*/
//    @Value("${app.version}")
//    private String appVersion;          /*授权应用版本*/
//    @Value("${app.termsOfServiceUrl}")
//    private String termsOfServiceUrl;   /*应用服务地址*/
//    @Value("${app.contact.name}")
//    private String contactName;         /*联系人*/
//    @Value("${app.contact.url}")
//    private String contactUrl;          /*联系url*/
//    @Value("${app.contact.email}")
//    private String contactEmail;        /*联系邮箱*/
//    @Value("${app.license}")
//    private String license;             /*版权信息*/
//    @Value("${app.licenseUrl}")
//    private String licenseUrl;
//    @Value("${app.apidoc}")
//    private String onApiDoc;           /*是否开启接口文档生成*/

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/apidoc/oauth2-redirect.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Bean
    public Docket api() {
        /*根据是否加参数略过test,生成asciidoc文档来决定是否启用swagger*/
        String skip1 = environment.getProperty("maven.test.skip");
        String skip2 = environment.getProperty("skipTests");
        logger.info("=======================================mvn:maven.test.skip={},skipTests={}", skip1, skip2);

        //默认开发模式开启swagger文档
        boolean onApiDoc = true;
        //只有本地开发,测试时开启文档
        if ("true".equals(skip1) || "true".equals(skip2)) {
            onApiDoc = false;
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .enable(onApiDoc)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lensyn.addresslist.controller"))
                .build()
                .securitySchemes(newArrayList(oauth()))
                .securityContexts(newArrayList(securityContext()));
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "WebApi在线文档|测试工具",
                "",
                "",
                "",
                new Contact("", "", ""),
                null,
                null,
                new ArrayList<>());
    }

    private SecurityContext securityContext() {
        AuthorizationScope[] scopes = new AuthorizationScope[]{new AuthorizationScope(scopeCode, "")};

        SecurityReference securityReference = SecurityReference
                .builder()
                .reference(type)
                .scopes(scopes)
                .build();

        return SecurityContext
                .builder()
                .securityReferences(newArrayList(securityReference))
                .forPaths(ant("/**"))
                .build();
    }

    private SecurityScheme oauth() {
        return new OAuthBuilder()
                .name(type)
                .grantTypes(grantTypes())
                .scopes(scopes())
                .build();
    }

    List<AuthorizationScope> scopes() {
        return newArrayList(new AuthorizationScope(scopeCode, ""));
    }

    List<GrantType> grantTypes() {
        List<GrantType> grants = newArrayList(new AuthorizationCodeGrant(
                new TokenRequestEndpoint(authorizationUrl, authClientId, authClientSecret),
                new TokenEndpoint(tokenUrl, tokenName)));
        return grants;
    }

    @Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration(authClientId, authClientSecret, scopeCode,
                "", "", ApiKeyVehicle.HEADER, "", ",");
    }
}
