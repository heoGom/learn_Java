package kr.co.greenart.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@GetMapping("/page")
	public String page() {
		return "redirectPage";
	}
	
	@GetMapping("/redirect")
	public String redirect(Model model) {
		model.addAttribute("attr", "value");
		
		return "redirect:/page";
	}
	
	@GetMapping("/redirect/flash")
	public String redirectFlash(RedirectAttributes attrs) {
		attrs.addFlashAttribute("flashAttr", "flashValue");
		
		return "redirect:/page";
	}
}






