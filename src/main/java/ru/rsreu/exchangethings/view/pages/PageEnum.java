package ru.rsreu.exchangethings.view.pages;

import ru.rsreu.exchangethings.configuration.JspResource;

public enum PageEnum {
    MAIN_PAGE_FOR_USERS(new StartPage("/user",
            "/admin",
            "")
    ),
    EMPTY(new CommonForwardPage(JspResource.getProperty("empty.path"))),
    USER_MAIN(new CommonForwardPage(JspResource.getProperty("user-main.path"))),
    ADMIN_MAIN(new CommonForwardPage(JspResource.getProperty("admin-main.path"))),
    LOGIN(new CommonForwardPage(JspResource.getProperty("login.path"))),
    USER(new CommonForwardPage(JspResource.getProperty("user.path"))),
    ADD_ITEM(new CommonForwardPage(JspResource.getProperty("user-add-item.path"))),
    CHOOSE_ITEM_FOR_EXCHANGE(new CommonForwardPage(JspResource.getProperty("user-choose-item.path"))),
    SEND_REDIRECT_USER(new CommonSendRedirectView("/user")),
    SEND_REDIRECT_ADMIN(new CommonSendRedirectView("/admin")),
    EDIT_HUMAN(new CommonForwardPage(JspResource.getProperty("edit-human.path"))),
    INFO_ITEM(new CommonForwardPage(JspResource.getProperty("item.path")));

    Page page;

    public Page getView() {
        return page;
    }

    PageEnum(Page page) {
        this.page = page;
    }
}
