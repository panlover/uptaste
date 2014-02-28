package cn.uptaste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 与首页相关的操作都在这里处理
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/","/home","/index.html"})
    public String homepage(){
        return "common/index";
    }
}
