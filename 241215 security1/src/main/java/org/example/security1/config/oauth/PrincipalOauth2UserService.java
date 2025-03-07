package org.example.security1.config.oauth;

import lombok.RequiredArgsConstructor;
import org.example.security1.config.auth.PrincipalDetails;
import org.example.security1.config.oauth.provider.GoogleUserInfo;
import org.example.security1.config.oauth.provider.NaverUserInfo;
import org.example.security1.config.oauth.provider.OAuth2UserInfo;
import org.example.security1.user.User;
import org.example.security1.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    final private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest); // google의 회원 프로필 조회

        // code를 통해 구성한 정보
        System.out.println("userRequest clientRegistration : " + userRequest.getClientRegistration());
        // token을 통해 응답받은 회원정보
        System.out.println("oAuth2User : " + oAuth2User);

        return processOAuth2User(userRequest, oAuth2User);
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {

        // Attribute를 파싱해서 공통 객체로 묶는다. 관리가 편함.
        OAuth2UserInfo oAuth2UserInfo = null;
        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            System.out.println("구글 로그인 요청~~");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        }  else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            System.out.println("네이버 로그인 요청~~");
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        } else {
            System.out.println("우리는 구글과 네이버만 지원해요 ㅎㅎ");
        }

        //System.out.println("oAuth2UserInfo.getProvider() : " + oAuth2UserInfo.getProvider());
        //System.out.println("oAuth2UserInfo.getProviderId() : " + oAuth2UserInfo.getProviderId());
        Optional<User> userOptional =
                userRepository.findByProviderAndProviderId(oAuth2UserInfo.getProvider(), oAuth2UserInfo.getProviderId());

        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            // user가 존재하면 update 해주기
            user.setEmail(oAuth2UserInfo.getEmail());
            userRepository.save(user);
        } else {
            // user의 패스워드가 null이기 때문에 OAuth 유저는 일반적인 로그인을 할 수 없음.
            user = User.builder()
                    .username(oAuth2UserInfo.getProvider() + "_" + oAuth2UserInfo.getProviderId())
                    .email(oAuth2UserInfo.getEmail())
                    .role("ROLE_USER")
                    .provider(oAuth2UserInfo.getProvider())
                    .providerId(oAuth2UserInfo.getProviderId())
                    .build();
            userRepository.save(user);
        }

        return new PrincipalDetails(user, oAuth2User.getAttributes());
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
