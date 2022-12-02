package ru.rsreu.exchangethings.view.pages;

import ru.rsreu.exchangethings.configuration.JspResource;

public enum PageEnum {
    EMPTY(new CommonForwardPage(JspResource.getProperty("empty.path"))),
    MAIN(new CommonForwardPage(JspResource.getProperty("main.path"))),
    LOGIN(new CommonForwardPage(JspResource.getProperty("login.path"))),
    USER(new CommonForwardPage(JspResource.getProperty("user.path"))),
    ADD_ITEM(new CommonForwardPage(JspResource.getProperty("user-add-item.path")));

    Page page;

    public Page getView() {
        return page;
    }

    PageEnum(Page page) {
        this.page = page;
    }
}
