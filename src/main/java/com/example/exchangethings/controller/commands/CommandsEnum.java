package com.example.exchangethings.controller.commands;

import com.example.exchangethings.configuration.ResourceJsp;
import com.example.exchangethings.helper.CommonHelper;
import com.example.exchangethings.view.CommonForwardView;
import com.example.exchangethings.view.CommonView;
import com.example.exchangethings.view.ViewEnum;

public enum CommandsEnum {
    LOGIN {
        {
            command = new ActionViewCommand(ViewEnum.TRUE.getView(), new CommonHelper());
        }
    },
    INPUT {
        {
            command = new ActionViewCommand(ViewEnum.LOGIN.getView(), new CommonHelper());
        }
    },
    LOGOUT {
        {
            command = new ActionViewCommand(new CommonForwardView(""), new CommonHelper());
        }
    },
    EMPTY {
        {
            command = new ActionViewCommand(ViewEnum.ERROR.getView(), new CommonHelper());
        }
    };

    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
