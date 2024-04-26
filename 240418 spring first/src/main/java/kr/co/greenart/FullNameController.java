package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// "/fullname" Get 요청 매핑
// "nameForm.jsp" foward

// nameForm.jsp = 이름 입력 form "firstName", "lastName" => Post Submit

// "/fullname" Post 요청 매핑
// "fullname.jsp" 결합된 이름 출력

@Controller
public class FullNameController {
	@RequestMapping(value = "/fullname", method = RequestMethod.GET)
	public String form() {
		return "nameForm";
	}
	
	@RequestMapping(value = "/fullname", method = RequestMethod.POST)
	public String formSubmit(Model model
			, @RequestParam String firstName
			, @RequestParam String lastName) {
		if (ObjectUtils.isEmpty(firstName.trim())) {
			model.addAttribute("firstNameError", "이름을 입력하세요");
			return "nameForm";
		}
		if (ObjectUtils.isEmpty(lastName.trim())) {
			model.addAttribute("lastNameError", "성을 입력하세요");
			return "nameForm";
		}
		
		
		String fullname = firstName + lastName;
		
		model.addAttribute("fullname", fullname);
		
		return "fullname";
	}
}







