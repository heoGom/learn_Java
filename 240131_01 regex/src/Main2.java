import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("Hello");
		Matcher m = p.matcher("Hello");
		
		
		System.out.println(m.matches());
		
		Matcher m2 = p.matcher("Hi");
		
		System.out.println(m2.matches());
	}

}
