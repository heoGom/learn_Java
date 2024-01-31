import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main9 {
	public static void main(String[] args) {
		// . => 1문자 일치. 예외)개행문자
		Pattern p = Pattern.compile("\\d+\\.\\d+");
		Matcher m = p.matcher("334.23");
		
		System.out.println(m.matches());
	}

}
