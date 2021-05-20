package cn.zdk.webdemo.controller;

import org.springframework.stereotype.Controller;

/**
 * @author zdk
 * @date 2021/5/20 20:45
 */
@Controller
public class IndexController {
    public String index(){
        return "index";
    }
}
