package kr.co.greenart.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cal")
public class CalculatorController {
	@GetMapping
	public String form() {
		return "calculatorForm";
	}

	@PostMapping(params = { "operator!=plus", "operator!=minus" })
	public String noSelect(Model model) {
		model.addAttribute("result", "올바른 연산자를 선택해주세요");
		
		return "calculatorResult";
	}
	
	@PostMapping(params = "operator=plus")
	public String plus(Model model, @RequestParam Integer num1, @RequestParam Integer num2) {
		int sum = num1 + num2;
		
		model.addAttribute("result", sum);
		
		return "calculatorResult";
	}
	
	@PostMapping(params = "operator=minus")
	public String minus(Model model, @RequestParam Integer num1, @RequestParam Integer num2) {
		model.addAttribute("result", num1 - num2);
		
		return "calculatorResult";
	}
}




