package cn.zdk.webdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author zdk
 * @date 2021/5/19 20:34
 */

//扩展springMVC

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //实现了public interface ViewResolver接口的类  可以作为视图解析器


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    /**
     * 定义自己视图解析器内部类
     */
    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
