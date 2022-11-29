package ru.rsreu.exchangethings.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.helper.MenuHelper;
import ru.rsreu.exchangethings.helper.beans.ItemBean;
import ru.rsreu.exchangethings.helper.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class UserItemsListHelper extends MenuHelper {
    public UserItemsListHelper() {
        super("list_items");
    }

    @Override
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("items",
                Arrays.asList(new ItemBean("dsa", "dsa", "das", new UserBean())
                        , new ItemBean("dsa", "dsa", "das", new UserBean()),
                        new ItemBean("dsa", "dsa", "das", new UserBean())));
        super.includeParamsInScopes(request, response);
    }
}
