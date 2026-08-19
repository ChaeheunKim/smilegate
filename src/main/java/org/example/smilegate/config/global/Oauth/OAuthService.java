package org.example.smilegate.config.global.Oauth;

import org.example.smilegate.user.domain.User;

public interface OAuthService {
    String getAccessToken(String code, String state);

    User getUserInfo(String accessToken);
    String getProviderName();

}