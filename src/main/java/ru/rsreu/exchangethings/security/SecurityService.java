package ru.rsreu.exchangethings.security;

import ru.rsreu.exchangethings.security.token.TokenInfo;
import ru.rsreu.exchangethings.security.token.TokenStorage;
import ru.rsreu.exchangethings.security.token.TokenStorageMap;

import java.util.HashMap;

public class SecurityService implements TokenStorage {
    private static SecurityService instance;

    private final TokenStorageMap storage;

    private SecurityService() {
        storage = new TokenStorageMap(new HashMap<>());
    }

    @Override
    public TokenInfo getId(String token) {
        return storage.getId(token);
    }

    @Override
    public void addToken(String token, TokenInfo id) {
        storage.addToken(token, id);
    }

    @Override
    public boolean tokenExist(String token) {
        return storage.tokenExist(token);
    }

    public static SecurityService getInstance() {
        if (instance == null)
            instance = new SecurityService();
        return instance;
    }

    @Override
    public void tokenRemove(String token) {
        if (token != null)
            storage.tokenRemove(token);
    }
}
