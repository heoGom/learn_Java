import java.util.regex.Pattern;

public class Main10 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("[-+]?(\\d+|\\d+\\.\\d+)");
		System.out.println(p.matcher("123.456").matches());
		System.out.println(p.matcher("123456").matches());
		System.out.println(p.matcher("12.3456").matches());
		System.out.println(p.matcher("-12.3456").matches());
		System.out.println(p.matcher(".3456").matches());
	}

}
