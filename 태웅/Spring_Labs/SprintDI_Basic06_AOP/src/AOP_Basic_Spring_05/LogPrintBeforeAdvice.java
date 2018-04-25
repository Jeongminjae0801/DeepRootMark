package AOP_Basic_Spring_05;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class LogPrintBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		Log log = LogFactory.getLog(this.getClass());
		log.info("Before Advice START!!!");
		log.info("Method: " + method.getName());
		log.info("Args: " + args.toString());
		log.info("Target: " + target.toString());
	}
	
}
