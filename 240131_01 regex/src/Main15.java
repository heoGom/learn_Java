import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main15 {
	public static void main(String[] args) {
		// 이메일 패턴 작성
		// 1. 영소문자로 시작
		// 2. 영소문자와 숫자로 구성
		// 3. 특수문자 @ 포함
		// 4. @ 이후에 도메인(영문자.영문자)문자.
		// 5. id 길이값 1~26자
		// 6. 도메인 길이값 3~10자
		// gjtjdwo1004@naver.com
		Pattern p = Pattern.compile("([a-z][a-z0-9]{0,25})@([a-z]{1,7}\\.[a-z]{2,3})");
		Pattern emptyP3 = Pattern.compile("[ \\s]");

		Scanner sc = new Scanner(System.in);
//		System.out.println("이메일을 적어봐");
		String input = "gjtjdwo1004@naver.com";

		if (!p.matcher(input).find()) {
			System.out.println("아이디의 문제");
		}

		if (emptyP3.matcher(input).find()) {
			System.out.println("띄어쓰기의 문제");
		}
		Matcher m = p.matcher(input);
		m.find();

		System.out.println(m.group(1));
		System.out.println(m.group(2));
	}

}
