package kr.co.greenart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 사용자 정보 입력 처리

// 사용자 정보
// 이름
// 이메일
// 나이
// 결혼유무
@Controller
public class UserController {
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserValidator validator;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(validator);
	}
	
	@ModelAttribute("command")
	public User defaultModel() {
		return new User();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userForm(@ModelAttribute("command") User user) {
		
		return "userForm";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String userSubmit(@Validated @ModelAttribute("command") User user, BindingResult errors) {
		log.info(user.toString());
		
		if (errors.hasErrors()) {
			return "userForm";
		}
		
		return "redirect:./";
	}
}






