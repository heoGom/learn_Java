package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // Component Scan 설정으로 Spring Bean 구성
public class MyController {
	// Handling Method
	// Model / View
	@RequestMapping(value = "/my", method = RequestMethod.GET)
	public String handlingMethod(Model model) {
		int sum = 1 + 1;
		
		model.addAttribute("sum", sum);
		
		return "my";
	}
	
	@RequestMapping(value = "/minus", method = RequestMethod.GET)
	public String minus(Model model) {
		int result = 10 - 5;
		
		model.addAttribute("result", result);
		
		return "minus";
	}
}



