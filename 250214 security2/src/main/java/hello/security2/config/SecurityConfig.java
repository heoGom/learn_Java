package hello.security2.config;

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
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
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
                );

        return http.build();
    }

}
