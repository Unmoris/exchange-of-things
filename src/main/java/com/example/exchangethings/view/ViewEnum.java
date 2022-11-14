package com.example.exchangethings.view;

import com.example.exchangethings.configuration.ResourceJsp;

public enum ViewEnum {
    ERROR {
        {
            this.view = new CommonForwardView(ResourceJsp.getProperty("error.path"));
        }
    },
    TRUE {
        {
            this.view = new CommonForwardView(ResourceJsp.getProperty("main.path"));
        }
    },
    LOGIN {
        {
            this.view = new CommonForwardView(ResourceJsp.getProperty("login.path"));
        }
    };

    View view;

    public View getView() {
        return view;
    }

}
