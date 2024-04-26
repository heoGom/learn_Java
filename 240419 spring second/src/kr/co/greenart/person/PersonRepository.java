package kr.co.greenart.person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
	@Autowired
	private JdbcTemplate template;
	
	private RowMapper<Person> rowMapper = new RowMapper<Person>() {
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			String name = rs.getString("name");
			int age = rs.getInt("age");
			return new Person(name, age);
		}
	};
	
	public int countTotal() {
		return template.queryForObject("SELECT COUNT(*) FROM person", int.class);
	}
	
	public List<Person> findAll() {
		return template.query("SELECT * FROM person", rowMapper);
	}
	
	public List<Person> findPage(int limit, int offset) {
		return template.query("SELECT * FROM person LIMIT ? OFFSET ?", rowMapper, limit, offset);
	}
	
	public int save(Person p) {
		return template.update("INSERT INTO person (name, age) VALUES (?, ?)"
								, p.getName(), p.getAge());
	}
	
	public Person findByPk(String name) {
		try {
			return template.queryForObject("SELECT * FROM person WHERE name = ?", rowMapper, name);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}


	public int delete(String name) {
		return template.update("DELETE FROM person WHERE name = ?", name);
	}
}










