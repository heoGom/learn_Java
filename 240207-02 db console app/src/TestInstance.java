import java.time.LocalDate;

public class TestInstance {
	public static void main(String[] args) {
		PersonDAO dao1 = PersonDAOImpl.getInstance();
		PersonDAO dao2 = PersonDAOImpl.getInstance();
		PersonDAO dao3 = PersonDAOImpl.getInstance();
		
		System.out.println(dao1 == dao2);
		System.out.println(dao3 == dao2);

		Integer i1 = Integer.valueOf(100);
		Integer i2 = Integer.valueOf(100);
		System.out.println(i1 == i2);
	}
}
