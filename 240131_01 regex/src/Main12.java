import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main12 {
	public static void main(String[] args) {
		String line = "[ value1 : myname, value2 : yourname ]";
		Pattern p = Pattern.compile("\\[ (?<grp1>value1 : \\w+), (?<grp2>value2 : \\w+) \\]");
		
		Matcher m = p.matcher(line);
		
//		System.out.println(m.matches());
		
		if(m.find()) {
			System.out.println(m.group(1));
			System.out.println(m.group(2));
			
			System.out.println(m.group("grp1"));
			System.out.println(m.group("grp2"));
		}
	}

}
