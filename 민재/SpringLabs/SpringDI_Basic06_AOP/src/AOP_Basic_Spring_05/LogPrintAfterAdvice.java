package AOP_Basic_Spring_05;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

public class LogPrintAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnvalue, 
							   Method method, 
							   Object[] args, 
							   Object target) throws Throwable {
		
		Log log = LogFactory.getLog(this.getClass());
		log.info(" [ After Advice Start ] 빠밤 ");
		log.info("[보조업무] 주 업무(함수)가 실행되고 돌아와서 실행되는 함수");
		log.info("returnvalue : " + returnvalue);
		log.info("method : " + method.getName());
		log.info("args : " + Arrays.toString(args));
		log.info("target : " + target.toString());
		
	}

}
