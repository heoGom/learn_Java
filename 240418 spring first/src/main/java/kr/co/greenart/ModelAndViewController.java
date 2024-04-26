package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelAndViewController {
	@RequestMapping(value = "/m", method = RequestMethod.GET)
	public String method1(Model model) {
		model.addAttribute("속성이름", "속성값");
		
		return "뷰이름";
	}
	
	@RequestMapping(value = "/mm", method = RequestMethod.GET)
	public String method2(ModelMap modelMap) {
		modelMap.addAttribute("속성이름", "속성값");
		
		return "뷰이름";
	}
	
	@RequestMapping(value = "/mv", method = RequestMethod.GET)
	public ModelAndView method3(ModelAndView mv) {
		mv.addObject("속성이름", "속성값");
		mv.setViewName("뷰이름");
		
		return mv;
	}
}



