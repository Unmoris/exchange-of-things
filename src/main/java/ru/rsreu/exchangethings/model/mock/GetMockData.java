package ru.rsreu.exchangethings.model.mock;

import ru.rsreu.exchangethings.view.beans.RequestBean;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.UserBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class GetMockData {

    static public List<ItemBean> getItemBean() {
        return Arrays.asList(new ItemBean("dsa", "test.png", "das", new UserBean())
                , new ItemBean("dsa", "test.png", "das", new UserBean()),
                new ItemBean("dsa", "test.png", "das", new UserBean()));
    }

    static public List<UserBean> getUserBean() {
        return Arrays.asList(new UserBean(1, "m.lapkin", "Миша",
                        "Лапкин", "Ильич", "1", "Пользователь", "заблокирован"),
                new UserBean(2, "m.lyagusheva", "Маша", "Лягушева", "Алексеевна", "1", "Пользователь", "разблокирован"));
    }

    static public List<RequestBean> getExchangeBean() {
        return Arrays.asList(new RequestBean(1, LocalDate.now().toString(), "1", "1", new ItemBean(), new ItemBean()), new RequestBean(1, LocalDate.now().toString(), "1", "1", new ItemBean(), new ItemBean()));
    }


}
