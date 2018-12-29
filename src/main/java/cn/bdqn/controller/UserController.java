package cn.bdqn.controller;

import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/index.hmtl",method = RequestMethod.POST)
    @ResponseBody
    public Object index(@RequestParam  String loginCode, @RequestParam String password, HttpSession session){
       int result=userService.getUser(loginCode,password);
       if(result==1){
           //还要修改登录时间
            return "success";
       }else if(result==-1){
           return "nologincode";
       }else if(result==-2){
           return  "failed";
       }else if(result==0){
           return "pwderror";
       }
       return "nodata";
    }

    @RequestMapping("/main.html")
    public String main(){
        return  "main";
    }

    @RequestMapping("/login.html")
    public String login(){
        return  "index";
    }
}
