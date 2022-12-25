package ru.rsreu.exchangethings.model.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.ItemService;
import ru.rsreu.exchangethings.model.service.RequestService;
import ru.rsreu.exchangethings.model.service.UserService;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.RequestBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

public class DeleteUserHelper implements Helper {
    UserService userService = UserService.instance;
    private ItemService itemService = ItemService.instance;
    private RequestService requestService = RequestService.instance;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int userId = 1;
        userService.deleteUser(userId);
    }
}
