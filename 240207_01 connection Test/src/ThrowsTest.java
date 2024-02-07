
public class ThrowsTest {
	public static int runtimeExcep() {
		try {

		return 10 / 0;
		}catch(RuntimeException e) {
			System.out.println("뭐가 먼저 돌아갈까?");
		}
		return 0;
	}

	public static boolean checkedExcep(int num) throws Exception {
		if (num > 0) {
			return true;
		}
		throw new Exception("체크드 예외");
	}

	public static void main(String[] args) {
		
		try {
			runtimeExcep();
		} catch (RuntimeException e) {
			System.out.println("예외처리 성공");
		}
	}

}
