import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		// 문자열 정보
		// 스캐너에서 사용자 id를 문자열로 입력받음
		Scanner scan = new Scanner(System.in);
		System.out.println("아이디를 입력하세요.");
		String id = scan.nextLine();

		// 1~10자여야 한다.
		int length = id.length();
		if (length < 0 || length > 10) {
			System.out.println("아이디는 1~ 10자여야한다.");
			return;

		}
		//공백을 포함을 해서는 안된다.{ \\t\\r\\n] :\\s
		Pattern p = Pattern.compile("[ \\s]");
		if(p.matcher(id).find()) {
			System.out.println("공백을 포함해서는 안됩니다.");
			return;
		}
		
		// 영소문자여야만 한다.
		Pattern p2 = Pattern.compile("[a-z]+");
		if(!p2.matcher(id).matches()) {
			System.out.println("아이디는 영 소문자여야합니다.");
			return;
		}
		System.out.println("사용가능한 아이디입니다.");
	}

}
