package AOP_Basic_02;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/*
 * 보조 업무를 담당
 보조 관심 구현
 (하나의 함수가 여러개의 함수를 대리 해야한다) : invoke
*/


public class LogPrintHandler implements InvocationHandler{
	private Object target; //실객체의 주소값
	public LogPrintHandler(Object target) { //실객체 주소를 파라미터로 받았다
		System.out.println("LogPringHandler 보조 관심사 생성자 호출");
		this.target=target;
	}
	
	//invoke (ADD , MUL , SUB) 를 대리하는 함수 
	//invoke 함수안에 보조업무 포함
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Invoke 함수 호출 (start)");
		System.out.println("method : " + method);
		System.out.println("args : " + Arrays.toString(args));
		
		//보조(공통) 업무
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw= new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		//주업무(실제 Target 객체의 주소) -> Calc 에서 구현된 실 함수를 호출 (parameter 정보 가지고)
		int result = (int)method.invoke(this.target, args); //public LogPrintHandler(Object target) 실객체를 호출 한다
		
		//보조(공통) 업무
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[TIME LOG] Method : ADD");
		log.info("[TIME LOG] Method Time : " + sw.getTotalTimeMillis());
		
		return result;
	}
	
	

}
