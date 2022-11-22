package ru.rsreu.exchangethings.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.helper.LoggerHelper;
import ru.rsreu.exchangethings.helper.beans.ItemBean;
import ru.rsreu.exchangethings.helper.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class UserItemsHelper extends UserMenuHelper {
    public UserItemsHelper() {
        super("my_items");
    }

    @Override
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("items",
                Arrays.asList(new ItemBean("dsa", "dsa", "das")
                        , new ItemBean("dsa", "dsa", "das"),
                        new ItemBean("dsa", "dsa", "das")));
        super.includeParamsInScopes(request,response);
    }
}
