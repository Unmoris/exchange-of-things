package com.example.exchangethings.controller.commands;

import com.example.exchangethings.helper.LoggerHelper;
import com.example.exchangethings.helper.LoginHelper;
import com.example.exchangethings.model.mock.TestLogging;
import com.example.exchangethings.view.CommonForwardView;
import com.example.exchangethings.view.ViewEnum;

public enum CommandsEnum {
    LOGIN {
        {
            command = new ActionViewCommand(ViewEnum.TRUE.getView(), ViewEnum.LOGIN.getView(), new LoginHelper(new TestLogging()));
        }
    },
    INPUT {
        {
            command = new ActionViewCommand(ViewEnum.LOGIN.getView(), new LoggerHelper());
        }
    },
    LOGOUT {
        {
            command = new ActionViewCommand(new CommonForwardView(""), new LoggerHelper());
        }
    },
    EMPTY {
        {
            command = new ActionViewCommand(ViewEnum.ERROR.getView(), new LoggerHelper());
        }
    };

    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
