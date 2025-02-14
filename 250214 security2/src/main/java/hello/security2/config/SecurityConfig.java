package hello.security2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됩니다.
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
                                        .loginProcessingUrl("/login") // /login 주소가 호출되면 시큐리티가 낚아채서 대신 로그인을 진행해준다.
                                        .defaultSuccessUrl("/")
                );

        return http.build();
    }

}
