package AOP_Basic_Spring_04;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogPrintAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("Around Advice Invoke Start");
		System.out.println("Method: " + method);
		
		//보조업무(공통사항)
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");

		//주업무: 실 객체의 함수 호출.
		Object result = method.proceed();
		System.out.println(result);
		
		//보조업무(공통사항)
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[TIME LOG] Method Time: " + sw.getTotalTimeSeconds());
		
		return result;
	}
	
	
}