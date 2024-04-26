package kr.co.greenart.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.greenart.json.DuplicateException;
import kr.co.greenart.json.NotFoundException;

@Service
public class PersonService {
	@Autowired
	private PersonRepository repo;
	
	@Transactional(readOnly = true)
	public List<Person> findAll() {
		return repo.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<Person> findPage(Pageable pageable) {
		List<Person> list = repo.findPage(pageable.getPageSize(), (int) pageable.getOffset());
		
		int total = repo.countTotal();
		
		return new PageImpl<Person>(list, pageable, total);
	}
	
	@Transactional
	public Person save(Person p) {
		Person find = repo.findByPk(p.getName());
		
		if (find != null) {
			throw new DuplicateException(HttpStatus.CONFLICT, "Conflict");
		}
		int result = repo.save(p);
		return p;
	}

	@Transactional(readOnly = true)
	public Person findByPk(String name) {
		return repo.findByPk(name);
	}

	@Transactional
	public void delete(String name) {
		Person find = findByPk(name);
		
		if (find == null) {
			throw new NotFoundException(HttpStatus.NOT_FOUND, "Not Found");
		}
		
		repo.delete(name);
	}
}
