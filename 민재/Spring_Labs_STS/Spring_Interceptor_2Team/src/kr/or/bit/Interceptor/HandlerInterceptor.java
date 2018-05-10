package kr.or.bit.Interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HandlerInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
				
		try {
			//logininfo 세션값이 null일경우
			if(request.getSession().getAttribute("loginInfo") == null ){
				//로그인 페이지로 redirect
				System.out.println("세션 값이 존재하지 않습니다");	
				response.sendRedirect("login.do");
					
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//null이 아니면 정상적으로 컨트롤러 호출
		return true;	
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("Session 값 : " + request.getSession().getAttribute("loginInfo"));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		Log log =	LogFactory.getLog(this.getClass());
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String date = dayTime.format(new Date(time));
		log.info(date); // 현재 시간 찍기
	}
}
