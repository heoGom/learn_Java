import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dbutil.MySqlConnectionProvider;

public class PersonService {
	// Dependency Injection : DI
	// 생성자와 Setter 주입
	private PersonDAO dao;

	public PersonService(PersonDAO dao) {
		this.dao = dao;
	}
	
	public void setDao(PersonDAO dao) {
		this.dao = dao;
	}

	// 목록 보기
	public List<Person> getAll() {
		return dao.getAll();
	}
	
	// 행 추가하기
	public int insert(Person p) {
		Connection conn = null;
		try {
			conn = MySqlConnectionProvider.getConnection();
			if (dao.getByPK(p.getName(), conn) != null) {
				return 0;
			}
			
			return dao.insert(p, conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터 베이스 작업 중 문제가 발생하였습니다. 관리자에게 문의하세요.");
		} finally {
			MySqlConnectionProvider.closeConnection(conn);
		}
	}
}





