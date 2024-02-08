import java.util.List;
import java.util.Scanner;

/*
	person table 입/출력
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PersonService service = new PersonService(PersonDAOImpl.getInstance());
		
		System.out.println("1. 인적 정보 기록 / 2. 인적 정보 목록 보기 / 3. 종료");
		int command = scan.nextInt();
		scan.nextLine();
		
		try {
			if (command == 1) {
				System.out.println("이름?");
				String name = scan.nextLine();
				System.out.println("나이?");
				int age = scan.nextInt();
				
				int result = service.insert(new Person(name, age));
				System.out.println(result == 1 ? "기록되었습니다." : "중복된 이름으로 기록할 수 없습니다.");
			} else if (command == 2) {
				List<Person> list = service.getAll();
				System.out.println("-- 목록 --");
				for (Person p : list) {
					System.out.println(p.toString());
				}
			} else {
				System.exit(0);
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}


