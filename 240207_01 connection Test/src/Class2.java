
public class Class2 {
	public static final int VALUE = 1;
	
	static {
		System.out.println("클래스 로드가 되는 시점에 실행됩니다.");
	}

	public static void printVALUE() {
		System.out.println(VALUE);
	}

}
