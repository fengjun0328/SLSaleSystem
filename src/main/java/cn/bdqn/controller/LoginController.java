package cn.bdqn.controller;

import cn.bdqn.pojo.*;
import cn.bdqn.service.affiche.AfficheService;
import cn.bdqn.service.function.FunctionService;
import cn.bdqn.service.information.InformationService;
import cn.bdqn.service.user.UserService;
import cn.bdqn.util.Constants;
import cn.bdqn.util.RedisAPI;
import com.alibaba.fastjson.JSONArray;
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
import java.util.*;

@Controller
@Scope("prototype")
public class LoginController extends  BaseController {

    private Logger logger = Logger.getLogger(LoginController.class);

    @Resource
    private UserService userService;
    @Resource
    private FunctionService functionService;
    @Resource
    private InformationService informationService;
    @Resource
    private AfficheService afficheService;
    @Resource
    private RedisAPI redisAPI;

    /**
     * 登录的方法
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public boolean login(HttpSession session, @RequestParam  String loginCode, @RequestParam String password){
        logger.debug("=============>");
        try {
            User user = userService.getLoginUser(loginCode, password);
            if(user!=null){
                session.setAttribute(Constants.SESSION_USER, user);
                user.setLastLoginTime(new Date());
                userService.modifyUser(user);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  false;
    }
    /**
     * 注销的方法
     * @param session
     * @return
     */
    @RequestMapping("/logout.html")
    public String logout(HttpSession session){
        session.removeAttribute(Constants.SESSION_USER);
        session.invalidate();
        this.setCurrentUser(null);
        return "index";
    }

    @RequestMapping("/main.html")
    public ModelAndView main(HttpSession session){
        List<Information> infoList = null;
        List<Affiche> afficheList = null;
        Information information = new Information();
        Affiche affiche = new Affiche();
        information.setStarNum(0);
        information.setPageSize(5);
        information.setState(1);
        affiche.setStarNum(0);
        affiche.setPageSize(5);
        try {
            infoList = informationService.getInformationList(information);
            afficheList = afficheService.getPortalAfficheList(affiche);
        } catch (Exception e) {
            infoList = null;
            afficheList = null;
        }
        List<Menu> mList=null;
        User user=this.getCurrentUser();
        if(user!=null){
            Map<String,Object> model = new HashMap<String,Object>();
            model.put("user",user);
            if(redisAPI.exist("menulist"+user.getRoleId())){
                String redisMenuListKeyString=redisAPI.get("menulist"+user.getRoleId());
                logger.debug("++++++++++++++++++++++++:menuList from redis:"+redisMenuListKeyString);
                if(redisMenuListKeyString!=null&&"".equals(redisMenuListKeyString)){
                    return  new ModelAndView("index");
                }else{
                    model.put("mList",redisMenuListKeyString);
                }
            }else {
                mList=getFuncByCurrentUser(user.getRoleId());
                //json
                if(null != mList){
                    String jsonString = JSONObject.toJSONString(mList);
                    model.put("mList", jsonString);
                    redisAPI.set("menuList"+user.getRoleId(), jsonString);
                }
            }
            if(!redisAPI.exist("Role"+user.getRoleId()+"UrlList")){
                try{
                    //get all role url list to redis
                    Authority authority = new Authority();
                    authority.setRoleId(user.getRoleId());
                    List<Function> functionList = functionService.getFunctionListByRoId(authority);
                    if(null != functionList){
                        StringBuffer sBuffer = new StringBuffer();
                        for(Function f:functionList){
                            sBuffer.append(f.getFuncUrl());
                        }
                        redisAPI.set("Role"+user.getRoleId()+"UrlList", sBuffer.toString());
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            model.put("infoList", infoList);
            model.put("afficheList", afficheList);
            session.setAttribute(Constants.SESSION_BASE_MODEL, model);
            return new ModelAndView("main",model);
        }else {
            return  new ModelAndView("index");
        }
    }

    /**
     * 根据当前用户的角色id的到功能列表（对应菜单）
     */
    protected List<Menu> getFuncByCurrentUser(int roleId){
        List<Menu> menuList = new ArrayList<Menu>();
        Authority authority = new Authority();
        authority.setRoleId(roleId);
        try {
            List<Function> mList = functionService.getMainFunctionList(authority);
            if(null != mList){
                for (Function function : mList) {
                    Menu menu = new Menu();
                    menu.setMainMenu(function);
                    function.setRoleId(roleId);
                    List<Function> subList = functionService.getSubFunctionList(function);
                    if(null != subList)
                        menu.setSubMenus(subList);
                    menuList.add(menu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }
    @RequestMapping("/regsuccess.html")
    public ModelAndView regSuccess(User user){
        int result;
        try {
            result = userService.addUser(user);
            if(result > 0){
                user = userService.getLoginUser(user.getLoginCode(),user.getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("regsuccess");
    }

    @RequestMapping("/401.html")
    public ModelAndView noRole(User user){
        return new ModelAndView("401");
    }
}
