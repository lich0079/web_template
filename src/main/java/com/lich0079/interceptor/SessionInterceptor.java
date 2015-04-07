package com.lich0079.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lich0079.util.BaseLogAble;

public class SessionInterceptor extends BaseLogAble implements  HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		  String url=request.getRequestURL().toString();
		  log(url);
//		  if(url.contains("login.do")||url.contains("checkListHistory.do")){
//			  return true;
//		  }
//		  HttpSession session=request.getSession();
//		  if(session.getAttribute("user")==null){
//			  request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
//	            return false;
//		  }
		return true;
	}

}
