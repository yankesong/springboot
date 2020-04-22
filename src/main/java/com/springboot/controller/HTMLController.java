package com.springboot.controller;
import com.springboot.service.BuyCarService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/page")
public class HTMLController {
    @Autowired
    private UserService userService;
    @Autowired
    private BuyCarService buyCarService;
    @RequestMapping("/userList")
    public String userList(){
        return "userlist";//返回对应的名为userlist的页面
    }
    @RequestMapping("/userLogin")
    public String userLogin(){
        return "userlogin";//返回对应的名为userlogin的页面
    }
    @RequestMapping("/buycarSave")
    public String buycarSave(){
        return "buycarsave";//返回对应的名为buycarSave的页面
    }
    @RequestMapping("/buycarList")
    public String buycarList(){
        return "buycarlist";//返回对应的名为buycarlist的页面
    }
}