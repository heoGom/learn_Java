package hello.security2.oauth;

import hello.security2.auth.PrincipalDetails;
import hello.security2.oauth.provider.OAuth2UserInfo;
import hello.security2.oauth.provider.googleUserInfo;
import hello.security2.oauth.provider.naverUserInfo;
import hello.security2.user.User;
import hello.security2.user.UserRepository;
import hello.security2.util.BcryptEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    // 구글로 부터 받은 userRequest 데이터에 대한 후처리 되는 함수
    // 함수 종료 시 @AuthenticationPrincipal 어노테이션이 만들어진다.
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        showAll(userRequest);

        OAuth2User oAuth2User = super.loadUser(userRequest);

        // 회원가입 강제 진행
        OAuth2UserInfo oAuth2UserInfo = null;
        if(userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            System.out.println("구글 로그인 요청");
            oAuth2UserInfo = new googleUserInfo(oAuth2User.getAttributes());
        } else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
            System.out.println("네이버 로그인 요청");
            oAuth2UserInfo = new naverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        }

        String provider = oAuth2UserInfo.getProvider();
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider + "_" + providerId; // google_sub
        String password = bCryptPasswordEncoder.encode("허곰");
        String email = oAuth2UserInfo.getEmail();
        String role = "ROLE_USER";
        User userEntity = userRepository.findByUsername(username);

        if(userEntity == null) {
            userEntity = User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .providerId(providerId)
                    .provider(provider)
                    .build();

            userRepository.save(userEntity);
        }

        return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
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
