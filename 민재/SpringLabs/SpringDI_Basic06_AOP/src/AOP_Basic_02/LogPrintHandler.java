package AOP_Basic_02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/*
	보조 관심 구현
	-> 하나의 함수가 여러개의 함수를 대리해야 한다 (invoke)

 */


public class LogPrintHandler implements InvocationHandler{
	
	private Object target;
	public LogPrintHandler(Object target) {
		System.out.println("LogPrintHandler 보조 관심사 생성자 호출");
		this.target = target;
	}
	
	// invoke (add, mul , sub) 대리하는 함수
	// invo
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke 함수 호출(Start)");
		System.out.println("method : " + method);
		System.out.println("agrs : " + Arrays.toString(args));
		
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("타이머 시작");
		
		///////////////////// 주 업무 //////////////////////
		// (실제 target 객체의 주소) -> Calc에서 구현한 실함수를 호출한다
		// 파라미터 정보를 가지고 들어온다
		int result = (int)method.invoke(this.target, args);
		// 실 객체 호출
		/////////////////////////////////////////////////
		
		sw.stop();
		log.info("타이머 종료");
		log.info("[TIme Log] Method : Add");
		log.info("[Time Log] Method time : " + sw.getTotalTimeMillis());
		
		return result;
	}

}
