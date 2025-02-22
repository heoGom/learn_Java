package hello.security2.config;

import hello.security2.auth.PrincipalDetailsService;
import hello.security2.oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됩니다.
@EnableMethodSecurity(
        securedEnabled = true,  // @Secured 활성화, 컨트롤러에서 개별적으로 권한을 설정할 수 있다.
        prePostEnabled = true  // @PreAuthorize, @PostAuthorize 활성화
//        jsr250Enabled = true    // @RolesAllowed 활성화 (JSR-250 표준)
)
@RequiredArgsConstructor
public class SecurityConfig {
    private final PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, PrincipalDetailsService principalDetailsService) throws Exception {
        http.csrf(csrf -> csrf.disable());

        http
                .authorizeHttpRequests(authorize ->
                                authorize
                                        .requestMatchers("/user/**").authenticated() // 인증만 되면 들어갈수 있는 주소

                                        // hasAnyAuthority("ADMIN") 의 경우 데이터베이스상 "ADMIN"으로 되어있어야한다.
//                                     .requestMatchers("/manager/**").hasAnyAuthority("ADMIN", "MANAGER")
//                                     .requestMatchers("/admin/**").hasAuthority("ADMIN")

                                        // hasAnyRole("ADMIN") 의 경우 데이터베이스상 "ROLE_ADMIN"으로 되어있어야한다.(
                                        .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER") // or 조건 예시
                                        .requestMatchers("/admin/**").hasRole("ADMIN") // and 조건 예시
                                        .anyRequest().permitAll() // 나머지 . 그냥 가능

                )
                .formLogin(form ->
                                form
                                        .loginPage("/loginForm")
                                        .loginProcessingUrl("/login") // /login 주소가 호출ㄷ괴면 시큐리티가 낚아채서 대신 로그인을 진행
                                        .defaultSuccessUrl("/") // 로그인 성공하면 기본값으로 홈화면으로 보냄
                )
                // 구글 로그인
                // 1. 코드받기(인증) 2. 엑세스 토큰(권한) 3. 사용자프로필 정보를 가져오고 4-1. 그 정보를 토대로 회원가입을 자동으로 진행
                // 4-2. (이메일, 전화번호, 이름, 아이디) 만약 쇼핑몰이라면 -> (집주소), 백화점의 경우 (VIP등급)
                .oauth2Login(oauth2 ->
                        oauth2
                                .loginPage("/loginForm") // 구글 로그인이 완료된 뒤의 후처리 필요함
                                .userInfoEndpoint(userInfoEndpoint ->
                                        userInfoEndpoint
                                                .userService(principalOauth2UserService)) // 구글 로그인이 완료된 뒤의 후처리 필요함 Tip. 코드X,(엑세스토큰+사용자프로필정보 O)

                );

        return http.build();
    }

}
