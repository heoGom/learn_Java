
public class ClassLoadingTest {
	static {
		System.out.println("언제 실행되나요?");
	}

	public static void main(String[] args) {
		System.out.println("HELLO WORLD!");
		
//		System.out.println(Class2.VALUE);
//		Class2.printVALUE();
		
		try {
			Class.forName("Class2");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
