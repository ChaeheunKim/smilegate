package org.example.smilegate.user.service.OauthService;

import org.example.smilegate.config.global.Oauth.OAuthService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OAuthServiceFactory {

    private final Map<String, OAuthService> services;

    public OAuthServiceFactory(List<OAuthService> oAuthServices) {
        this.services = oAuthServices.stream()
                .collect(Collectors.toMap(OAuthService::getProviderName, service -> service));
    }

    public OAuthService getService(String provider) {
        OAuthService service = services.get(provider.toLowerCase());
        if (service == null) {
            throw new IllegalArgumentException("지원하지 않는 로그인 방식입니다: " + provider);
        }
        return service;
    }
}

