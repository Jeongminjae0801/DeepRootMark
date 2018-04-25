package AOP_Basic_Spring_05;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

public class LogPrintAfterAdvice implements AfterReturningAdvice {
	
	
	
	@Override
	public void afterReturning(Object returnvalue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println(returnvalue.toString());
		
		Log log = LogFactory.getLog(this.getClass());
		log.info("보조업무 After Advice START!!!");
		log.info("Return-Value: " + returnvalue.toString());
		log.info("Method: " + method.getName());
		log.info("Args: " + Arrays.toString(args));
		log.info("Target: " + target.toString());
		log.info("[보조업무] 주업무(함수)가 실행되고 돌아와서 바로 실행되는 함수");
	}

	
}
