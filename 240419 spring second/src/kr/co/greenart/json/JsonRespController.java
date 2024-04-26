package kr.co.greenart.json;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import kr.co.greenart.person.Person;
import kr.co.greenart.person.PersonService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/api/person")
@CrossOrigin
@Slf4j
public class JsonRespController {
	@Autowired
	private PersonService service;
	
	@GetMapping
	@ResponseBody
	public List<Person> json() {
		return service.findAll();
	}
	
	@GetMapping(params = {"page", "size"})
	@ResponseBody
	public Page<Person> getPage(@PageableDefault(size = 5) Pageable pageable) {
		return service.findPage(pageable);
	}
	
	@GetMapping("/{name}")
	@ResponseBody
	public Person findByPk(@PathVariable String name) {
		Person find = service.findByPk(name);
		
		if (find == null) {
			throw new NotFoundException(HttpStatus.NOT_FOUND, "Not Found");
		}
		return find;
	}
	
	@DeleteMapping("/{name}")
	public ResponseEntity<?> delete(@PathVariable String name) {
		service.delete(name);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping
	public ResponseEntity<Person> jsonInput(@Valid @RequestBody Person p, BindingResult error) {
		log.info(p.toString());
		
		if (error.hasErrors()) {
			throw new InvalidPersonException(HttpStatus.BAD_REQUEST, "invalid person data", error);
		}
		
		Person result = service.save(p);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(result);
	}
}






