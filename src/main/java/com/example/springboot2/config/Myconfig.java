package com.example.springboot2.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.example.springboot2.bean.User;
import com.example.springboot2.converters.UserConverters;
import com.example.springboot2.interceptor.LoginInterceptor;
import com.example.springboot2.interceptor.RedisCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class Myconfig {

    @Autowired
    RedisCountInterceptor redisCountInterceptor;

     @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**","/actuator/**","/druid/**");
                registry.addInterceptor(redisCountInterceptor)
                        .addPathPatterns("/**")
                        .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**");            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypes = new HashMap<>();
//                mediaTypes.put("json", MediaType.APPLICATION_JSON);
//                mediaTypes.put("xml", MediaType.APPLICATION_XML);
                mediaTypes.put("user", MediaType.parseMediaType("application/user"));
                ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();
                configurer.strategies(Arrays.asList(parameterStrategy, headerContentNegotiationStrategy));
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new UserConverters());
            }
        };
    }

//    @ConfigurationProperties("spring.datasource")
//    @Bean
//    public DataSource dataSource() throws SQLException {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        //StatFilter 用于统计监控信息；如SQL监控、URI监控
//        druidDataSource.setFilters("stat");
//        return druidDataSource;
//    }

//    /**
//     * StatViewServlet的用途包括：
//     * 提供监控信息展示的html页面
//     * 提供监控信息的JSON API
//     * @return
//     */
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        StatViewServlet statViewServlet=new StatViewServlet();
//        ServletRegistrationBean<StatViewServlet> registrationBean=new ServletRegistrationBean<>(statViewServlet,"/druid/*");
//        return registrationBean;
//    }
//
//    /**
//     * WebStatFilter 用于采集web-jdbc关联监控的数据
//     */
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//        WebStatFilter webStatFilter=new WebStatFilter();
//        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
//        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//        webStatFilterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return webStatFilterFilterRegistrationBean;
//    }
}