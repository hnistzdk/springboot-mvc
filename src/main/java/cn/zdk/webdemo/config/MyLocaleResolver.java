package cn.zdk.webdemo.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author zdk
 * @date 2021/5/22 11:08
 * 实现自己的地区解析器(国际化)
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("language");
        //如果没有就使用默认
        Locale locale = Locale.getDefault();
        //如果请求的连接携带了国际化的参数
        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            //国家_地区
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
