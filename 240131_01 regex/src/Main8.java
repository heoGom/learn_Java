import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main8 {
	public static void main(String[] args) {
		// \w : [A-Za-z0-9_]
		// \d : [0-9]
		// ? :{0,1}
		// + :{1,}
		Pattern p = Pattern.compile("\\w+");
		
		Matcher m = p.matcher("");
		
		System.out.println(m.matches());
	}

}
