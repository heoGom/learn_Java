import java.util.regex.Pattern;

public class Main14 {
	public static void main(String[] args) {
		String kor = "한글표현입니다";
		
		Pattern p = Pattern.compile("[ㄱ-힣]+");
		System.out.println(p.matcher(kor).matches());
	}

}
