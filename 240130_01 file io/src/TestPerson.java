import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPerson {
	public static void main(String[] args) {
//		List<Person> list = new ArrayList<>(Arrays.asList(
//				new Person("길동",180,77.77,true),
//				new Person("둘리",190,88.88,true),
//				new Person("도우너",200,99.99,true)
//				));
		PersonRepository repo = new PersonRepository();
		
//		for(Person p : list) {
//			repo.insertRow(p);
//		}
		System.out.println(repo.getAllPersons());
	}

}
