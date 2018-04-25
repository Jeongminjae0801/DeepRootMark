package AOP_Basic_02;

import java.lang.reflect.Proxy;

import AOP_Basic_01.Cal;

public class Program {

	public static void main(String[] args) {
		Calc calc = new NewCalc();
		//calc.ADD(100,200)
		
		//Proxy 객체를 통해서 처리 (가짜)
		Calc cal = (Calc)Proxy.newProxyInstance(calc.getClass().getClassLoader(),
				               calc.getClass().getInterfaces(),
				               new LogPrintHandler(calc));
		
		//Proxy를 통해서 처ㅣ하지만
		//사용자는 실제 Calc 객체를 사용하는 것처럼........
		//MUL, ADD, SUB >> LogPrintHandler 객체의 invoke 함수 호출(대리 함수)
		//int result = cal.ADD(1000, 2000);
		int result = cal.MUL(1000, 2000);
		System.out.println("main : " + result);
	}

}
