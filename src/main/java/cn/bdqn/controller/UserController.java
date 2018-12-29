package cn.bdqn.controller;

import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import org.apache.log4j.Logger;
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
    private static Logger logger=Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login.hmtl",method = RequestMethod.POST)
    @ResponseBody
    public Object index(@RequestParam  String loginCode, @RequestParam String password, HttpSession session){
        logger.debug("==================>");
       int result=userService.getUser(loginCode,password);
       if(result==1){
           //还要修改登录时间
           logger.debug("reslut:"+result);
            return "success";
       }else if(result==-1){
           logger.debug("reslut:"+result);
           return "nologincode";
       }else if(result==-2){
           logger.debug("reslut:"+result);
           return  "failed";
       }else if(result==0){
           logger.debug("reslut:"+result);
           return "pwderror";
       }
       return "nodata";
    }

    @RequestMapping("/main.html")
    public String main(){
        return  "main";
    }

    @RequestMapping(value = "/login.html",method = RequestMethod.GET)
    public String login(){
        logger.debug("登录=====================》");
        return  "index";
    }
}
