package ru.rsreu.exchangethings.model.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class UserItemsHelper extends MenuHelper {
    public UserItemsHelper() {
        super("my_items");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("items",
                Arrays.asList(new ItemBean("dsa", "test.png", "das", new UserBean())
                        , new ItemBean("dsa", "test.png", "das", new UserBean()),
                        new ItemBean("dsa", "test.png", "das", new UserBean())));
        super.execute(request, response);
    }
}
