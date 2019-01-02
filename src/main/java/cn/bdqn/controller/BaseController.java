package cn.bdqn.controller;

import cn.bdqn.pojo.User;
import cn.bdqn.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {
    private Logger logger = Logger.getLogger(BaseController.class);

    private User currentUser;

    /**
     * 获取session的user对象
     * @return
     */
    public User getCurrentUser() {
        if(this.currentUser==null){
            HttpServletRequest request= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session=request.getSession(false);
            if(session!=null){
                this.currentUser=(User)session.getAttribute(Constants.USER_SESSION);

            }else {
                this.currentUser=null;
            }
        }
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * 处理日期格式
     * @param dataBinder
     */
    @InitBinder
    public void InitBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                } catch(ParseException e) {
                    setValue(null);
                }
            }
            public String getAsText() {
                return new SimpleDateFormat("yyyy-MM-dd").format((Date) getValue());
            }
        });
    }
}
