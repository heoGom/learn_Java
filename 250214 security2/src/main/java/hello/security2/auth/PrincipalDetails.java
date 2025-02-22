package hello.security2.auth;

// 시큐리티가 /login 주소요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인을 진행이 완료가 되면 시큐리티 session을 만들어준다.(Security ContextHolder)
// 시큐리티안 session에 들어갈수 있는 오브젝트 => Authentication 타입 객체
// Authentication 안에 User 정보가 있어야됨.
// User오브젝트의 타입 => UserDetails 타입 객체

// security Session => Authentication => UserDetails(PrincipalDetails)

import hello.security2.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
@Setter
public class PrincipalDetails implements UserDetails, OAuth2User {

    private User user; //컴포지션

    public PrincipalDetails(User user) {
        this.user = user;
    }


    //해당 유저의 권한을 리턴하는 곳!!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                return user.getRole(); //ROLE_USER
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }


    @Override
    public boolean isEnabled() {

        // 우리사이트 기준 1년동안 회원이 로그인을 안하면 휴면개정으로 하기로함
        // 현재시간 - 로긴시간 => 1년을 초과하면 return false;

        return true;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Map<String, Object> getAttributes() {
        return Map.of();
    }
}
