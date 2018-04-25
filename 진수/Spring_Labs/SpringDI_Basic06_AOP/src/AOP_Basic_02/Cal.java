package AOP_Basic_02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/*
 * 주관심 + 보조관심 합쳐진것
 * 이 를 나눈것이 , Calc(주관심), LogPrintHandler(보조 관심)
간단한 계산기 프로그램
-주관심 : 사칙연산(ADD , MUL)
-보조관심(공통관심) : 연산에 걸린 시간  
log 출력 (console 출력 : 시스템 제공하는 하는 것처럼 RED 색으로 ......)
*/

public class Cal {
	public int Add(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());
		//System.currentTimemillis()
		StopWatch sw= new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		int result = x + y;// 주간심
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[TIME LOG] Mehtod:ADD");
		log.info("[TIME LOG] Mehtod Time : " + sw.getTotalTimeMillis());
		
		return result;
	}
	
	public int Mul(int x, int y) {
		
		Log log = LogFactory.getLog(this.getClass());
		//System.currentTimemillis()
		StopWatch sw= new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		int result = x * y;// 주간심
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[TIME LOG] Mehtod:MUL");
		log.info("[TIME LOG] Mehtod Time : " + sw.getTotalTimeMillis());
		
		return result;
	}
}
