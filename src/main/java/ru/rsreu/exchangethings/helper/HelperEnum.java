package ru.rsreu.exchangethings.helper;

import ru.rsreu.exchangethings.helper.login.LoginHelper;
import ru.rsreu.exchangethings.helper.user.UserExchangesHelper;
import ru.rsreu.exchangethings.helper.user.UserInfoHelper;
import ru.rsreu.exchangethings.helper.user.UserItemsHelper;
import ru.rsreu.exchangethings.model.mock.TestLogging;

public enum HelperEnum {
    LOGIN(new LoginHelper(new TestLogging())),
    LOGGER(new LoggerHelper()),
    USER_INFO(new UserInfoHelper()),
    USER_ITEMS(new UserItemsHelper()),
    USER_EXCHANGES(new UserExchangesHelper());
    private Helper helper;

    HelperEnum(Helper info) {
        this.helper = info;
    }

    public Helper getHelper() {
        return helper;
    }
}
