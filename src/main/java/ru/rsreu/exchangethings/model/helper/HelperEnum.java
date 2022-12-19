package ru.rsreu.exchangethings.model.helper;

import ru.rsreu.exchangethings.model.helper.Items.AddNewItemHelper;
import ru.rsreu.exchangethings.model.helper.Items.ChooseItemHelper;
import ru.rsreu.exchangethings.model.helper.Items.BlockItemHelper;
import ru.rsreu.exchangethings.model.helper.Items.StartExchangeItem;
import ru.rsreu.exchangethings.model.helper.Items.HideItem;
import ru.rsreu.exchangethings.model.helper.Items.InfoItemHelper;
import ru.rsreu.exchangethings.model.helper.Items.OpenItem;
import ru.rsreu.exchangethings.model.helper.Items.UnBlockItemHelper;
import ru.rsreu.exchangethings.model.helper.admin.AddHumanHelper;
import ru.rsreu.exchangethings.model.helper.admin.AuthorizedUsersHelper;
import ru.rsreu.exchangethings.model.helper.admin.EditDeleteHumanHelper;
import ru.rsreu.exchangethings.model.helper.admin.GetHumanByIdHelper;
import ru.rsreu.exchangethings.model.helper.exchange.CancelExchangeHelper;
import ru.rsreu.exchangethings.model.helper.exchange.DeleteExchangeHelper;
import ru.rsreu.exchangethings.model.helper.exchange.SetStatusApproveExchangeHelper;
import ru.rsreu.exchangethings.model.helper.login.LoginHelper;
import ru.rsreu.exchangethings.model.helper.moderator.AllExchangesHelper;
import ru.rsreu.exchangethings.model.helper.moderator.AllItemsHelper;
import ru.rsreu.exchangethings.model.helper.moderator.AllUsersHelper;
import ru.rsreu.exchangethings.model.helper.moderator.UserBlockHelper;
import ru.rsreu.exchangethings.model.helper.moderator.UserUnBlockHelper;
import ru.rsreu.exchangethings.model.helper.user.DeleteUserHelper;
import ru.rsreu.exchangethings.model.helper.user.SaveUserHelper;
import ru.rsreu.exchangethings.model.helper.user.UpdateUserHelper;
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
    LIST_ITEMS_FOR_USER(new ItemsListForUserHelper()),
    ADD_HUMAN(new AddHumanHelper()),
    EDIT_DELETE_HUMANS(new EditDeleteHumanHelper()),
    EDIT_HUMAN(new GetHumanByIdHelper()),
    SHOW_AUTHORIZED_HUMAN(new AuthorizedUsersHelper()),
    ITEM_INFO(new InfoItemHelper()),
    ALL_USERS(new AllUsersHelper()),
    ALL_EXCHANGES(new AllExchangesHelper()),
    ALL_ITEMS(new AllItemsHelper()),
    OPEN_ITEM(new OpenItem()),
    HIDE_ITEM(new HideItem()),
    START_EXCHANGE_ITEM(new StartExchangeItem()),
    CHOOSE_ITEMS(new ChooseItemHelper()),
    CANCEL_EXCHANGE(new CancelExchangeHelper()),
    APPROVE_EXCHANGE(new SetStatusApproveExchangeHelper()),
    USER_BLOCK(new UserBlockHelper()),
    USER_UNBLOCK(new UserUnBlockHelper()),
    DELETE_REQUEST(new DeleteExchangeHelper()),
    BLOCK_ITEM(new BlockItemHelper()),
    UNBLOCK_ITEM(new UnBlockItemHelper()),
    HUMAN_SAVE_EDIT(new UpdateUserHelper()),
    HUMAN_SAVE(new SaveUserHelper()),
    DELETE_USER(new DeleteUserHelper());
    private Helper helper;

    HelperEnum(Helper info) {
        this.helper = info;
    }

    public Helper getHelper() {
        return helper;
    }
}
