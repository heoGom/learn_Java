package org.example.security1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.security1.user.User;
import org.example.security1.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller//뷰를 리턴하겠다.
public class IndexController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"","/"})
    public String index() {
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
    //스프링 시큐리티가 잡아가버림
    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }
    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }
    @PostMapping("/join")
    public String join(User user) {
        user.setRole("USER");
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);

        userRepository.save(user); //이렇게 하면 시큐리티로 로그인 할수 없음. 이유는 패스워드가 암호화가 안되었기 때문
        return "redirect:/loginForm";
    }
}
