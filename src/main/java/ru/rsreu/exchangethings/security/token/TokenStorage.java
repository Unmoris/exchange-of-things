package ru.rsreu.exchangethings.security.token;

import ru.rsreu.exchangethings.security.token.TokenExist;
import ru.rsreu.exchangethings.security.token.TokenGetId;
import ru.rsreu.exchangethings.security.token.TokenRemover;

public interface TokenStorage  extends TokenRemover, TokenExist, TokenGetId, TokenAdder {
}
