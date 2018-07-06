package kr.or.bit.aspect;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;

@Aspect
public class AspectJ {

	@Pointcut("execution(* kr.or.bit.controller.MainController.*(..))") //MainController에 있는 모든 함수
	public void pointcut() {}
	
	
	@Before("pointcut()")
	public void before(JoinPoint joinpoint) {
		Log log =	LogFactory.getLog(this.getClass());
		log.info("Before");
		long time = System.currentTimeMillis(); 

		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

		String date = dayTime.format(new Date(time));

		log.info(date); // 현재 시간 찍기
		log.info(joinpoint.getSignature().getName()); //MainController에서 부른 함수이름 찍기
		
	}
	
	public void after(JoinPoint joinpoint) {
		Log log =	LogFactory.getLog(this.getClass());
		log.info("After");
		long time = System.currentTimeMillis(); 

		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

		String date = dayTime.format(new Date(time));

		log.info(date); // 현재 시간 찍기
		log.info(joinpoint.getSignature().getName()); //MainController에서 부른 함수이름 찍기
		
	}
}
