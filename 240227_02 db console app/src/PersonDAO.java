import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {
	// 행추가
	int insert(Person p, Connection conn);
	// person 행 검색(pk)
	Person getByPk(String name, Connection conn);
	// person 목록 조회
	List<Person> getAll();
	
	default Person resultMapping(ResultSet rs) throws SQLException {
		String name = rs.getString("name");
		int age = rs.getInt("age");
		return new Person(name, age);
		
	}
}
