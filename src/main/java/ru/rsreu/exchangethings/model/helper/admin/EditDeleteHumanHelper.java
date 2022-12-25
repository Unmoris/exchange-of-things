package ru.rsreu.exchangethings.model.helper.admin;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditDeleteHumanHelper extends MenuHelper {
    private UserService userService = UserService.instance;
    public EditDeleteHumanHelper() {
        super("edit_delete_human");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("users", userService.getAllUsersByRole(UserRoleEnum.USER));
        super.execute(request, response);
    }
}
