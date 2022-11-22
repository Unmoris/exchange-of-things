package ru.rsreu.exchangethings.view;

import ru.rsreu.exchangethings.configuration.JspResource;

public enum ViewEnum {
    EMPTY {
        {
            this.view = new CommonForwardView(JspResource.getProperty("empty.path"));
        }
    },
    MAIN {
        {
            this.view = new CommonForwardView(JspResource.getProperty("main.path"));
        }
    },
    LOGIN {
        {
            this.view = new CommonForwardView(JspResource.getProperty("login.path"));
        }
    },
    USER
    {
        {
            this.view = new CommonForwardView(JspResource.getProperty("user.path"));
        }
    };

    View view;

    public View getView() {
        return view;
    }

}
