package org.example.security1.config;

import lombok.RequiredArgsConstructor;
import org.example.security1.config.oauth.PrincipalOauth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // secured 어노테이션 활성화, preAuthorize, postAuthorize 어노테이션 활성화
// @EnableWebSecurity Spring Boot 2.1 부터 @Configuration과 SecurityFilterChain이 있으면 자동으로 Spring Security가 활성화
public class SecurityConfig {

    // 해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.
    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }

    final private PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //TODO : 로그아웃 구현 후 없애야함
        http.csrf(csrf -> csrf.disable());
        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/user/**").authenticated() // 인증만 되면 들어갈수 있는 주소

                                // AnyAuthority("ADMIN") 의 경우 데이터베이스상 "ADMIN"으로 되어있어야한다.
//                                .requestMatchers("/manager/**").hasAnyAuthority("ADMIN", "MANAGER")
//                                .requestMatchers("/admin/**").hasAuthority("ADMIN")

                                // AnyRole("ADMIN") 의 경우 데이터베이스상 "ROLE_ADMIN"으로 되어있어야한다.
                                 .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER") // or 조건 예시
                                 .requestMatchers("/admin/**").hasRole("ADMIN") // and 조건 예시
                                .anyRequest().permitAll() // 나머지 . 그냥 가능
                )
                .formLogin(form ->
                        form
                                .loginPage("/loginForm")
//                                .usernameParameter("username22") // loginForm의 네임을 바꿀려면 이렇게 바꿀수 있다.
                                .loginProcessingUrl("/login") // /login 주소가 호출되면 시큐리티가 낚아채서 대신 로그인을 진행해준다.
                                .defaultSuccessUrl("/")
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout") // 로그아웃 URL
                                .logoutSuccessUrl("/login?logout") // 로그아웃 후 이동할 URL
                                .invalidateHttpSession(true) // 세션 무효화
                                .deleteCookies("JSESSIONID") // 쿠키 삭제
                )
                // 구글 로그인
                // 1. 코드받기(인증) 2. 엑세스 토큰(권한) 3. 사용자프로필 정보를 가져오고 4-1. 그 정보를 토대로 회원가입을 자동으로 진행
                // 4-2. (이메일, 전화번호, 이름, 아이디) 만약 쇼핑몰이라면 -> (집주소), 백화점의 경우 (VIP등급)
                .oauth2Login(oauth2 ->
                        oauth2
                                .loginPage("/loginForm")
                                .userInfoEndpoint(userInfoEndpoint ->
                                        userInfoEndpoint
                                                .userService(principalOauth2UserService)) // 구글 로그인이 완료된 뒤의 후처리 필요함 Tip. 코드X,(엑세스토큰+사용자프로필정보 O)
                );


        return http.build();
    }


}
