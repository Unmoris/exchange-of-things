package ru.rsreu.exchangethings.security;

import ru.rsreu.exchangethings.security.token.TokenInfo;

import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Logger;

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

    public void registration(HttpServletRequest request, TokenInfo info) {
        String token = generateNewToken();
        request.getSession().setAttribute("token", token);
        Logger.getLogger("security").info(token);

        securityService.addToken(token, info);
    }

    public static TokenRegistrar getInstance() {
        if (instance == null)
            instance = new TokenRegistrar(SecurityService.instance);
        return instance;
    }

}
