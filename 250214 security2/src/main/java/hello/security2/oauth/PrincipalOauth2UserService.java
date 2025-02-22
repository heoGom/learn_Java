package hello.security2.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    // 구글로 부터 받은 userRequest 데이터에 대한 후처리 되는 함수
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        showAll(userRequest);

        return super.loadUser(userRequest);
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
