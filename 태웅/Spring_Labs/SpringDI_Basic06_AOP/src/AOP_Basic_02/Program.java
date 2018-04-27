package AOP_Basic_02;

import java.lang.reflect.Proxy;

public class Program {

	public static void main(String[] args) {
		
		Calc calc = new NewCalc();
		/*
			int result = calc.ADD(100, 200);
			System.out.println("Add result : " + result);
			
			result = calc.MUL(100,200);
			System.out.println("Mul result : " + result);
		*/
		//Proxy 객체를 통해서 처리
		//loader: 실객체의 주소값
		
		Calc cal = (Calc)Proxy.newProxyInstance(calc.getClass().getClassLoader(), 	//실제 클래스 메타 정보
												calc.getClass().getInterfaces(), 	//행위정보(인터페이스)
												new LogPrintHandler(calc));			//핸들러(보조관심)>> 실객체 주소(생성자)
		
		//Proxy를 통해서 처리하지만, 사용자는 실제 Calc 객체를 사용하는 것처럼...
		cal.ADD(100, 200);
		
		cal.MUL(200, 30);
	}

}
