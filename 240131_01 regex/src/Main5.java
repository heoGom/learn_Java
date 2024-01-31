import java.util.regex.Pattern;

public class Main5 {
	public static void main(String[] args) {
		String input1 = "str10";
		String input2 = "str21";
		String input3 = "str32";
		
		Pattern p = Pattern.compile("str[13579][02468]");
		System.out.println(p.matcher(input1).matches());
		System.out.println(p.matcher(input2).matches());
		System.out.println(p.matcher(input3).matches());
		
		
	}

}
