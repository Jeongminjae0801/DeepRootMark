package AOP_Basic_Spring_04;

public class NewCalc implements Calc{

	@Override
	public int Add(int x, int y) {
		// 보조 업무(공통 업무 : cross-cutting concern)
		int sum = x + y;	//주 업무(core concern)
		// 보조 업무(공통 업무 : cross-cutting concern)
		return sum;
	}

	@Override
	public int Mul(int x, int y) {
		// 보조 업무(공통 업무 : cross-cutting concern)
		int mul = x * y;	//주 업무(core concern)
		// 보조 업무(공통 업무 : cross-cutting concern)
		return mul;
	}

	@Override
	public int sub(int x, int y) {
		// 보조 업무(공통 업무 : cross-cutting concern)
		int sub = x - y;	//주 업무(core concern)
		// 보조 업무(공통 업무 : cross-cutting concern)
		return sub;
	}

}
