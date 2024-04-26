package kr.co.greenart.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {
	@Autowired
	private PersonService service;
	
	@GetMapping("/person")
	public String personList(Model model
			, @PageableDefault(page = 0, size = 5) Pageable pageable) {
		Page<Person> findPage = service.findPage(pageable);
		
		model.addAttribute("findPage", findPage);
		
		return "persons";
	}
}
