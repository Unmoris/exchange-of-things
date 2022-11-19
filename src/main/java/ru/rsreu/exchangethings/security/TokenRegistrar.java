package ru.rsreu.exchangethings.security;

import ru.rsreu.exchangethings.security.token.TokenInfo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.Base64;

public class TokenRegistrar {

    private static TokenRegistrar instance;

    private TokenRegistrar(SecurityService securityService) {
        this.securityService = securityService;
    }

    SecurityService securityService;
    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    private Cookie getCookie(String token) {
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(-1);
        return cookie;
    }

    public void registration(HttpServletResponse response, TokenInfo info) {
        String token = generateNewToken();

        response.addCookie(this.getCookie(token));

        securityService.addToken(token, info);
    }

    public void registration(HttpServletRequest request, TokenInfo info) {
        String token = generateNewToken();

        request.getSession().setAttribute("token", token);

        securityService.addToken(token, info);
    }

    public static TokenRegistrar getInstance() {
        if (instance == null)
            instance = new TokenRegistrar(SecurityService.getInstance());
        return instance;
    }

}
