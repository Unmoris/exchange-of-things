package ru.rsreu.exchangethings.security.token;

public interface TokenAdder {
    public void addToken(String token, TokenInfo id);
}
