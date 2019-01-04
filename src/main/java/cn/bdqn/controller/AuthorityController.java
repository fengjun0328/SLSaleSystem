package cn.bdqn.controller;


import cn.bdqn.pojo.*;
import cn.bdqn.service.authority.AuthorityService;
import cn.bdqn.service.function.FunctionService;
import cn.bdqn.service.role.RoleService;
import cn.bdqn.util.Constants;
import cn.bdqn.util.RedisAPI;
import com.alibaba.fastjson.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class AuthorityController extends BaseController {
	private Logger logger = Logger.getLogger(AuthorityController.class);
	@Resource
	private RoleService roleService;
	@Resource
	private FunctionService functionService;
	@Resource
	private AuthorityService authorityService;
	@Resource
	private RedisAPI redisAPI;
	@Resource
	private LoginController loginController;
	
	@RequestMapping(value = "/backend/modifyAuthority.html", produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public Object modifyAuthority(HttpSession session, @RequestParam String ids){
		
		String resultString = "nodata";
		try {
			if(null != ids){
				String[] idsArrayStrings =ids.split("-");
				if(idsArrayStrings.length > 0){
					User user = (User)session.getAttribute(Constants.SESSION_USER);
					authorityService.hl_addAuthority(idsArrayStrings,user.getLoginCode());
					List<Menu> mList=null;
					mList = loginController.getFuncByCurrentUser(Integer.valueOf(idsArrayStrings[0]));
					redisAPI.set("menuList"+idsArrayStrings[0],JSONArray.toJSONString(mList));
					
					Authority authority = new Authority();
					authority.setRoleId(Integer.valueOf(idsArrayStrings[0]));
					List<Function> functionList = functionService.getFunctionListByRoId(authority);
					
					if(null != functionList || functionList.size() >= 0){
						StringBuffer sBuffer = new StringBuffer();
						for(Function f:functionList){
							sBuffer.append(f.getFuncUrl());
						}
						redisAPI.set("Role"+idsArrayStrings[0]+"UrlList", sBuffer.toString());
					}
					resultString = "success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}
	
	@RequestMapping(value = "/backend/getAuthorityDefault.html", produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public Object getAuthorityDefault(@RequestParam Integer rid,@RequestParam Integer fid){
		String resultString = "nodata";
		try {
			Authority authority = new Authority();
			authority.setRoleId(rid);
			authority.setFunctionId(fid);
			if(authorityService.getAuthority(authority) != null){
				resultString =  "success";
			}
		} catch (Exception e) {
		}
		return resultString;
	}
	
	@RequestMapping(value = "/backend/functions.html", produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public Object functions(){
		String resultString = "nodata";
		Function function = new Function();
		try {
			function.setId(0);
			List<Function> fList = functionService.getSubFuncList(function);
			List<RoleFunctions> rList = new ArrayList<RoleFunctions>();
			if(null != fList){
				
				for(Function func : fList){
					RoleFunctions rFunctions = new RoleFunctions();
					rFunctions.setMainFunction(func);
					rFunctions.setSubFunctions(functionService.getSubFuncList(func));
					rList.add(rFunctions);
				}
				resultString = JSONArray.toJSONString(rList);
			}
		} catch (Exception e) {
		}
		return resultString;
	}
	
	
	
	@RequestMapping("/backend/authoritymanage.html")
	public ModelAndView authorityManage(HttpSession session, Model model){
		
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			List<Role> roleList = null;
			try {
				roleList = roleService.getRoleIdAndNameList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				roleList = null;
			}
			model.addAllAttributes(baseModel);
			model.addAttribute(roleList);
			return new ModelAndView("/backend/authoritymanage");
		}
	}
	
}
