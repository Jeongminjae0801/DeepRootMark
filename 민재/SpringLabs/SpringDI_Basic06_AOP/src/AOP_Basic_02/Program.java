package AOP_Basic_02;

import java.lang.reflect.Proxy;

public class Program {

	public static void main(String[] args) {
		Calc calc = new NewCalc();
		
		//calc.add(100,200)
		
		// Proxy 객체를 통해서 처리(가짜)
		Calc cal = (Calc)Proxy.newProxyInstance(
								calc.getClass().getClassLoader(), //실제 클래스 메타 정보 
								calc.getClass().getInterfaces(), //행위정보(인터페이스)
								new LogPrintHandler(calc)); //핸들러(보조관심)
								// -> 실객체 주소(생성자)
		//Proxy 를 통해서 처리하지만
		// 사용자는 실제 Calc 객체를 사용하는 것 처럼 느낀다
		// add , mul, sub -> LogPrintHandler 객체의 invoke 함수 호출(대리함수)
		
		//int result = cal.Add(5, 5);
		int result = cal.Mul(25, 5);
		System.out.println("main : " + result);
	}
}
