package hello.security2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping({"","/"})
    public String index() {
        // 머스태치의 기본폴더 src/main/resources/templates
        return "index";
    }
    @GetMapping("/user")
    public @ResponseBody String user() {
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager() {
        return "manager";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public @ResponseBody String join() {
        return "join";
    }

    @GetMapping("joinProc")
    public @ResponseBody String joinProc() {
        return "회원가입 완료됨!";
    }


}
