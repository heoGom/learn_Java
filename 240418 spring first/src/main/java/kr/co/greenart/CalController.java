package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalController {
	@Autowired
	private Calculator calculator;
	// "/cal" Get 요청 매핑
	// form.jsp로 forward
	@RequestMapping(value = "/cal", method = RequestMethod.GET)
	public String calForm() {
		return "form";
	}
	
	// "/cal" Post 요청 매핑
	// result.jsp로 forward
	@RequestMapping(value = "/cal", method = RequestMethod.POST)
	public String calSubmit(Model model
			, @RequestParam(value = "num1", defaultValue = "0") Integer num1
			, @RequestParam(value = "num2", defaultValue = "0") Integer num2) {
		int result = calculator.sum(num1, num2);
		
		model.addAttribute("result", result);
		
		return "result";
	}
}







