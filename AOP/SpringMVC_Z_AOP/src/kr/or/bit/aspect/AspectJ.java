package kr.or.bit.aspect;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;

@Aspect
public class AspectJ {

	@Pointcut("execution(* kr.or.bit.controller.MainController.*(..))")
	public void pointcut() {}
	
	@Before("pointcut()")
	public Object before(JoinPoint joinpoint) {
	
		Date date = Calendar.getInstance().getTime();
		String time = date.getTime() + "-" + date.getHours() + "-" + date.getMinutes();
		
		System.out.println("before: ");
		
		
		return null;
		
	}
}
