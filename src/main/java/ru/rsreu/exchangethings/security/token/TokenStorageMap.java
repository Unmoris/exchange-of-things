package ru.rsreu.exchangethings.security.token;

import java.util.Map;

public class TokenStorageMap implements TokenStorage {

    private final Map<String, TokenInfo> tokens;

    public TokenStorageMap(Map<String, TokenInfo> tokens) {
        this.tokens = tokens;
    }

    @Override
    public boolean tokenExist(String token) {
        return tokens.containsKey(token);
    }

    @Override
    public TokenInfo getId(String token) {
        return tokens.get(token);
    }

    @Override
    public void tokenRemove(String token) {
        tokens.remove(token);
    }

    @Override
    public void addToken(String token, TokenInfo id) {
        tokens.put(token, id);
    }
}
