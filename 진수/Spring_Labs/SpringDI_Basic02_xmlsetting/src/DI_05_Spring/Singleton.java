package DI_05_Spring;

public class Singleton {
	private Singleton() {
	}
	private static Singleton intance = new Singleton();
	public static Singleton getInstance() {
		return intance;
	}
}
