package AOP_Basic_01;

public class Program {

	public static void main(String[] args) {
		Cal cal = new Cal();
		
		int result = cal.Add(100, 100);
		System.out.println(result);
		result = cal.Mul(20, 20);
		System.out.println(result);
		
	}

}
