package hello.security2.auth;

import hello.security2.user.User;
import hello.security2.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 loginProcessingUrl("/login");
// /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어 있는 loadUserByUsername 함수가 실행되는 규칙
// 인제 이 친구가 로그인에 대한 Service가 될 것이다.
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // 시큐리티 Session 내부(Authentication 내부(UserDetails))
    // 함수 종료 시 @AuthenticationPrincipal 어노테이션이 만들어진다.
    @Override
    // username을 html에서 input의 name을 username으로 동일하게 만들어줘야 받을 수 있다.
    // 만약 바꾸고싶다면 SecurityConfig에서 .usernameParameter("username2") 이렇게 정의해줘야함
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        if(userEntity != null) {
            return new PrincipalDetails(userEntity);
        }

        return null;
    }
}
