package ru.rsreu.exchangethings.security;

import ru.rsreu.exchangethings.security.token.TokenInfo;
import ru.rsreu.exchangethings.security.token.TokenStorage;
import ru.rsreu.exchangethings.security.token.TokenStorageMap;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class SecurityService implements TokenStorage {
    public static final SecurityService instance = new SecurityService();

    private final TokenStorageMap storage;

    private SecurityService() {
        storage = new TokenStorageMap(new HashMap<>());
    }

    @Override
    public TokenInfo getTokenInfo(String token) {
        return storage.getTokenInfo(token);
    }

    public TokenInfo getTokenInfo(HttpServletRequest request) {
        String token = (String) request.getSession().getAttribute("token");
        return getTokenInfo(token);
    }

    @Override
    public void addToken(String token, TokenInfo id) {
        storage.addToken(token, id);
    }

    @Override
    public boolean tokenExist(String token) {
        return storage.tokenExist(token);
    }

    @Override
    public void tokenRemove(String token) {
        if (token != null)
            storage.tokenRemove(token);
    }
}
