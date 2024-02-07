import java.util.List;

public class TestDAO {
	public static void main(String[] args) {
		PersonDAO dao = new PersonDAOImpl();

		List<Person> list = dao.getAll();
		System.out.println(list);
		int result = dao.insert(new Person("테스트인간", 33));
		System.out.println(result);
	}

}
