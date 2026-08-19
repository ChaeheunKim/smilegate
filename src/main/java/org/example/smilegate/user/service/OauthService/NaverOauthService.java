package org.example.smilegate.user.service.OauthService;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.example.smilegate.config.global.Oauth.OAuthService;
import org.example.smilegate.user.domain.User;
import org.example.smilegate.user.domain.UserRole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@NoArgsConstructor
@Service
@Transactional
public class NaverOauthService implements OAuthService {

    @Value("${naver.client.id}")
    private String clientId;

    @Value("${naver.client.secret}")
    private String clientSecret;


    @Override
    public String getAccessToken(String code, String state) {
        RestTemplate restTemplate = new RestTemplate();
        String tokenUrl = "https://nid.naver.com/oauth2.0/token";

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("code", code);
        params.add("state", state);

        HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(params);
        ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);

        return (String) response.getBody().get("access_token");
    }

    @Override
    public User getUserInfo(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.GET,
                entity,
                Map.class
        );

        Map<String, Object> body = response.getBody();
        Map<String, Object> userdata = (Map<String, Object>) body.get("response");
        return User.builder()
                .id((Long) userdata.get("id"))
                .email((String) userdata.get("email"))
                .role(UserRole.USER)
                .username((String) userdata.get("name"))
                .build();
    }
    public String getProviderName(){
        return "Naver";
    };



}




