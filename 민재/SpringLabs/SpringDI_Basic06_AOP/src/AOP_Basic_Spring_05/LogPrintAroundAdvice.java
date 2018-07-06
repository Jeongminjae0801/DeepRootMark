package AOP_Basic_Spring_05;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogPrintAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("[ Around Advice Invoke Start 뚜둥 ]");
		System.out.println("method : " + method);
		
		// 보조업무(공통사항)
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("타이머 시작");
		
		// 주 업무(실 객체 함수 호출)
		Object result = method.proceed();
		
		// 보조업무(공통사항)
		sw.stop();
		log.info("타이머 종료");
		log.info("[TIme Log] Method : Add");
		log.info("[Time Log] Method time : " + sw.getTotalTimeMillis());
		
		return result;
	}

	
}
