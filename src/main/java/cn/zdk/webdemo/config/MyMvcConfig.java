package cn.zdk.webdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zdk
 * @date 2021/5/19 20:34
 */

//扩展springMVC

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //实现了public interface ViewResolver接口的类  可以作为视图解析器

    /**
     * 添加视图控制器
     */

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 自定义的国际化类注入IOC容器
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login")
                .excludePathPatterns("/css/**","/js/**","/img/**");
    }
}
