package ru.rsreu.exchangethings.security.token;

public interface TokenStorage  {
    public TokenInfo getTokenInfo(String token);
    public void tokenRemove(String token);
    public void addToken(String token, TokenInfo id);
    public boolean tokenExist(String token);



}
