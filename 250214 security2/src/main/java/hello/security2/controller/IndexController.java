package hello.security2.controller;


import hello.security2.auth.PrincipalDetails;
import hello.security2.user.User;
import hello.security2.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/test/login")
    public @ResponseBody String loginTest(
            Authentication authentication,
            @AuthenticationPrincipal PrincipalDetails userDetails) { //의존성 주입

        System.out.println("/test/login =======================");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("authentication = " + principalDetails.getUser());
        System.out.println("userDetails = " + userDetails.getUser());

        return "세션정보확인하기";
    }

    @GetMapping("/test/oauth/login")
    public @ResponseBody String loginoauthTest(Authentication authentications,
                                               @AuthenticationPrincipal OAuth2User oAuth2) { //의존성 주입

        System.out.println("/test/login =======================");
        OAuth2User oAuth2User = (OAuth2User) authentications.getPrincipal();

        System.out.println("authentication = " + oAuth2User.getAttributes());
        System.out.println("oauth2User = " + oAuth2.getAttributes());

        return "OAuth세션정보확인하기";
    }


    @GetMapping({"", "/"})
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
        System.out.println("user = " + user);
        user.setRole("ROLE_USER");
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);

        userRepository.save(user);//회원가입은 잘됨. 비밀번호 = 1234 =>이렇게 하면 시큐리티로 로그인 할수 없음. 이유는 패스워드가 암호화가 안되었기 때문
        return "redirect:/loginForm";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/info")
    public @ResponseBody String info() {
        return "개인정보";
    }

    //    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')") //ROLE_ADMIN 이나 ADMIN 둘 다 가능하다.
    @GetMapping("/data")
    public @ResponseBody String data() {
        return "데이터정보";
    }
}
