import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBatch {
	public static void main(String[] args) {
		PersonDAOImpl dao = PersonDAOImpl.getInstance();
		System.out.println(dao.getAll());
		
		PersonService service = new PersonService(dao);
		int result = service.insert(new Person("사람48", 99));
		System.out.println(result);
		
		System.out.println(dao.getAll());
//		List<Person> list = new ArrayList<>(
//				Arrays.asList(
//						new Person("사람20", 1)
//						, new Person("사람21", 2)
//						, new Person("사람9", 3)
//						, new Person("사람22", 4)
//						, new Person("사람23", 5)
//						)
//				);
//		
//		int[] result = dao.batchAdd(list);
//		System.out.println(Arrays.toString(result));
		
		
	}

}
