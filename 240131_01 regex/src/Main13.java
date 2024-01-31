import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main13 {
	public static void main(String[] args) {
		//휴대폰 전화번호
		//010-xxxx-xxxx
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("휴대폰 전화번호?");
		String phoneNumber = sc.nextLine();
		
		Pattern p = Pattern.compile("010-(\\d{4})-(\\d{4})");
		Matcher m = p.matcher(phoneNumber);
//		System.out.println(m.matches());
		if(m.find()) {
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
	}

}
