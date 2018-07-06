package ncontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class handlerinterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler
			)throws Exception {
		request.setAttribute("mi.begintime", System.currentTimeMillis());
		System.out.println("hello!!!!!!!!!!!!!!");
				return true;
				}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			Exception ex
			) throws Exception {
		long begintime = (Long) request.getAttribute("mi.begintime");
		long endtime = System.currentTimeMillis();
		System.out.println(request.getRequestURI() + "실행시간 : " + (endtime - begintime));
		
	}

}
