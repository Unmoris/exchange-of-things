package ru.rsreu.exchangethings.model.helper;

import ru.rsreu.exchangethings.model.helper.Items.AddNewItemHelper;
import ru.rsreu.exchangethings.model.helper.Items.InfoItemHelper;
import ru.rsreu.exchangethings.model.helper.admin.AddHumanHelper;
import ru.rsreu.exchangethings.model.helper.admin.AuthorizedUsersHelper;
import ru.rsreu.exchangethings.model.helper.admin.EditDeleteHumanHelper;
import ru.rsreu.exchangethings.model.helper.admin.GetHumanByIdHelper;
import ru.rsreu.exchangethings.model.helper.login.LoginHelper;
import ru.rsreu.exchangethings.model.helper.user.UserExchangesHelper;
import ru.rsreu.exchangethings.model.helper.user.UserInfoHelper;
import ru.rsreu.exchangethings.model.helper.user.UserItemsHelper;
import ru.rsreu.exchangethings.model.helper.user.ItemsListForUserHelper;
import ru.rsreu.exchangethings.model.mock.TestLogging;

public enum HelperEnum {
    LOGIN(new LoginHelper(new TestLogging())),
    LOGGER(new LoggerHelper()),
    USER_INFO(new UserInfoHelper()),
    USER_ITEMS(new UserItemsHelper()),
    USER_EXCHANGES(new UserExchangesHelper()),
    ADD_ITEM(new AddNewItemHelper()),
    USER_LIST_ITEMS(new ItemsListForUserHelper()),
    ADD_HUMAN(new AddHumanHelper()),
    EDIT_DELETE_HUMANS(new EditDeleteHumanHelper()),
    EDIT_HUMAN(new GetHumanByIdHelper()),
    SHOW_AUTHORIZED_HUMAN(new AuthorizedUsersHelper()),
    ITEM_INFO(new InfoItemHelper());
    private Helper helper;

    HelperEnum(Helper info) {
        this.helper = info;
    }

    public Helper getHelper() {
        return helper;
    }
}
