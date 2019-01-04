package cn.bdqn.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.pojo.User;
import cn.bdqn.util.Constants;
import cn.bdqn.util.RedisAPI;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SysInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = Logger.getLogger(SysInterceptor.class);

	@Resource
	private RedisAPI redisAPI;
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		logger.debug("SysInterceptor preHandle ==========================");
		HttpSession session=request.getSession();
		String urlPath=request.getRequestURI();
		User user=(User)session.getAttribute(Constants.SESSION_USER);
		if(user==null){
			response.sendRedirect("/");
			return  false;
		}else{
			String keyString = "Role"+user.getRoleId() + "UrlList";
			String urlsString = "url:"+redisAPI.get(keyString);

			if(null != urlsString && !"".equals(urlsString) && urlsString.indexOf(urlPath) > 0){
				return true;
			}else {
				response.sendRedirect("/401.html");
				return false;
			}
		}
	}
}
