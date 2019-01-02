package cn.bdqn.controller;

import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import cn.bdqn.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger=Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 登录的方法
     * @param loginCode
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/login.html",method = RequestMethod.POST)
    @ResponseBody
    public boolean index(@RequestParam  String loginCode, @RequestParam String password, HttpSession session) {
        logger.debug("==================>" + loginCode + "_" + password);
        User user_login = new User();
        user_login.setPassword(password);
        user_login.setLoginCode(loginCode);
        try {
            User user_result = userService.getLoginUser(user_login);
            if (user_result != null) {
                User user_modify = new User();
                user_modify.setId(user_result.getId());
                user_modify.setLastLoginTime(new Date());
                userService.modifyUser(user_modify);
                session.setAttribute(Constants.USER_SESSION, user_result);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return  false;
    }

    /**
     * 判断用户是否存在
     * @return
     */

    @RequestMapping("/isExits.html")
    @ResponseBody
    public boolean loginCodeIsExists(@RequestParam String loginCode){
        User user=new User();
        user.setLoginCode(loginCode);
        try {
            int result=userService.loginCodeIsExit(user);
            if(result>0){
                return  true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  false;
    }

    @RequestMapping("/main.html")
    public String main(){
        return  "main";
    }

    @RequestMapping(value = "/login.html",method = RequestMethod.GET)
    public String login(){
        logger.debug("登录=====================》");
        return "/WEB-INF/index.jsp";
    }
}
