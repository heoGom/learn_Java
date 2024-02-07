import java.util.List;

public interface PersonDAO {
	//행추가
	int insert(Person p);
	//person 목록 조회
	List<Person> getAll();
}
