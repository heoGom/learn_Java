package org.example.security1.config.oauth;

import lombok.RequiredArgsConstructor;
import org.example.security1.config.auth.PrincipalDetails;
import org.example.security1.user.User;
import org.example.security1.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    final private BCryptPasswordEncoder bCryptPasswordEncoder;
    final private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 구글로그인 버튼 클릭 -> 구글로그인창 -> 로그인 완료 -> code를 리턴(OAuth-Client라이브러리) -> AccessToken요청
        // userRequest정보 -> loadUser함수 호출 -> 구글로부터 회원프로필을 받아준다.
        showAll(userRequest);

        OAuth2User oauth2User = super.loadUser(userRequest);

        String provider = userRequest.getClientRegistration().getClientId();
        String providerId = oauth2User.getAttribute("sub");
        String username = provider + "_" + providerId;
        String password = bCryptPasswordEncoder.encode(providerId);
        String email = oauth2User.getAttribute("email");
        String role = "ROLE_USER";
        User userentity = userRepository.findByUsername(username);

        if(userentity == null) {
            System.out.println("최초로그인 입니다.");
            userentity = User.builder()
                    .username(username)
                    .password(password)
                    .role(role)
                    .email(email)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userentity);
        }else{
            System.out.println("구글 로그인을 이미한적이 있습니다.");
        }
        
        return new PrincipalDetails(userentity, oauth2User.getAttributes());
    }

    private void showAll(OAuth2UserRequest userRequest) {
        System.out.println("userRequest = " + userRequest);
        //JWT토큰의 형태인거 같다.
        System.out.println("getAccessToken = " + userRequest.getAccessToken());
        System.out.println("getTokenValue = " + userRequest.getAccessToken().getTokenValue());
        System.out.println("getTokenType = " + userRequest.getAccessToken().getTokenType());
        System.out.println("getScopes = " + userRequest.getAccessToken().getScopes());
        System.out.println("getExpiresAt = " + userRequest.getAccessToken().getExpiresAt());
        System.out.println("getIssuedAt = " + userRequest.getAccessToken().getIssuedAt());
        System.out.println("getClass = " + userRequest.getAccessToken().getClass());
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("getClientRegistration = " + userRequest.getClientRegistration());
        System.out.println("getRegistrationId = " + userRequest.getClientRegistration().getRegistrationId());
        System.out.println("getClientId = " + userRequest.getClientRegistration().getClientId());
        System.out.println("getClientName = " + userRequest.getClientRegistration().getClientName());
        System.out.println("getClientSecret = " + userRequest.getClientRegistration().getClientSecret());
        System.out.println("getRedirectUri = " + userRequest.getClientRegistration().getRedirectUri());

        System.out.println("getAttributes = " + super.loadUser(userRequest).getAttributes());


    }
}
