package ru.rsreu.exchangethings.view;

import ru.rsreu.exchangethings.configuration.JspResource;

public enum ViewEnum {
    EMPTY(new CommonForwardView(JspResource.getProperty("empty.path"))),
    MAIN(new CommonForwardView(JspResource.getProperty("main.path"))),
    LOGIN(new CommonForwardView(JspResource.getProperty("login.path"))),
    USER(new CommonForwardView(JspResource.getProperty("user.path")));

    View view;

    public View getView() {
        return view;
    }

    ViewEnum(View view) {
        this.view = view;
    }
}
