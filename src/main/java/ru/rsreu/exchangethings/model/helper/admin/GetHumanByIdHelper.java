package ru.rsreu.exchangethings.model.helper.admin;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetHumanByIdHelper implements Helper {
    private UserService userService = UserService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int id = Integer.parseInt(request.getParameter("id_user"));
        request.setAttribute("user", userService.getUserById(id));
    }
}
