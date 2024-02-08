import java.sql.Connection;
import java.util.List;

import dbutil.MySqlConnectionProvider;

public class PersonService {
	// Dependency Injection : DI
	// 생성자외 Setter 주입
	private PersonDAO dao;

	public PersonService(PersonDAO dao) {
		super();
		this.dao = dao;
	}

	public PersonDAO getDao() {
		return dao;
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
			if (dao.getByPk(p.getName(), conn) != null) {
				return 0;
			}
			return dao.insert(p, conn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySqlConnectionProvider.closeConnection(conn);
		}
		return 0;

	}

}
