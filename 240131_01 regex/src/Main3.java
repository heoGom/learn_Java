import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
	public static void main(String[] args) {
		String input = "Hello. This is a book";
		
		Pattern p = Pattern.compile("is");
		
		Matcher m = p.matcher(input);
		
		System.out.println(m.matches());
		
		while(m.find()) {
			System.out.println("시작 : "+m.start());
			System.out.println("끝 : "+m.end());
			
		}
	}

}
