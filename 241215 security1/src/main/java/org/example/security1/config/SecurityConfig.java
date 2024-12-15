package org.example.security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.
    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/user/**").authenticated()
                                 .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER") // or 조건 예시
                                 .requestMatchers("/admin/**").hasRole("ADMIN") // and 조건 예시
                                .anyRequest().permitAll()
                )
                .formLogin(form ->
                        form
                                .loginPage("/loginForm")
//                                .loginProcessingUrl("/loginProc")
                                .defaultSuccessUrl("/")
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout") // 로그아웃 URL
                                .logoutSuccessUrl("/login?logout") // 로그아웃 후 이동할 URL
                                .invalidateHttpSession(true) // 세션 무효화
                                .deleteCookies("JSESSIONID") // 쿠키 삭제
                );


        return http.build();
    }


}
