package ru.rsreu.exchangethings.model.helper.admin;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.view.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class AuthorizedUsersHelper extends MenuHelper {
    public AuthorizedUsersHelper() {
        super("show_authorized_users");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("users", Arrays.asList(new UserBean(1, "m.lapkin", "Миша",
                "Лапкин", "Ильич", "1", "Пользователь", "Активен"),
                new UserBean(2, "m.lyagusheva", "Маша", "Лягушева", "Алексеевна", "1", "Пользователь", "Активен")));
        super.execute(request, response);
    }
}
