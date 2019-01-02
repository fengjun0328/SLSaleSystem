package cn.bdqn.controller;

import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import cn.bdqn.util.Constants;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@Scope("prototype")
public class LoginController extends  BaseController {

    private Logger logger = Logger.getLogger(LoginController.class);

    @Resource
    private UserService userService;

    /**
     * 登录的方法
     * @param session
     * @param user
     * @return
     */
    @RequestMapping(value = "/login.html",method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpSession session, @RequestParam String user){
        if(null == user || "".equals(user)){
            return "nodata";
        }else{
            JSONObject userObject = JSONObject.parseObject(user);
            User userObj =  (User)JSONObject.toJavaObject(userObject,User.class);
            try {
                if(userService.loginCodeIsExit(userObj) ==  0){//不存在这个登陆账号
                    return "nologincode";
                }else{
                    User _user = userService.getLoginUser(userObj);
                    if(null != _user){
                        session.setAttribute(Constants.USER_SESSION, _user);
                        User updateLoginTimeUser = new User();
                        updateLoginTimeUser.setId(_user.getId());
                        updateLoginTimeUser.setLastLoginTime(new Date());
                        userService.modifyUser(updateLoginTimeUser);
                        updateLoginTimeUser = null;
                        return "success";
                    }else {
                        return "pwderror";
                    }
                }
            } catch (Exception e) {
                return "failed";
            }
        }
    }

    @RequestMapping("/login.html")
    public String login(){
        return "/WEB-INF/index.jsp";
    }


    /**
     * 注销的方法
     * @param session
     * @return
     */
    @RequestMapping("/logout.html")
    public String logout(HttpSession session){
        session.removeAttribute(Constants.USER_SESSION);
        session.invalidate();
        this.setCurrentUser(null);
        return "/WEB-INF/index.jsp";
    }

    @RequestMapping("/main.html")
    public ModelAndView main(HttpSession session){
        return  new ModelAndView("main");
    }
}
