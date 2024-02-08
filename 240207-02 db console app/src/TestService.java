
public class TestService {
	public static void main(String[] args) {
		PersonService service = new PersonService(PersonDAOImpl.getInstance());
		
//		Person p = new Person("정일웅", 26);
//		int result = service.insert(p);
//		System.out.println(result);
		System.out.println(service.getAll());
	}
}
