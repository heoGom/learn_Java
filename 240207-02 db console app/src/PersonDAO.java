import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {
	// person 행 추가
	int insert(Person p, Connection conn);
	// person 행 검색(pk)
	Person getByPK(String name, Connection conn);
	// person 전체 행 조회
	List<Person> getAll();
	
	default Person resultMapping(ResultSet rs) throws SQLException {
		String name = rs.getString("name");
		int age = rs.getInt("age");
		return new Person(name, age);
	}
}
