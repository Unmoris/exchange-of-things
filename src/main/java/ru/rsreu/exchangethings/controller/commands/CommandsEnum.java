package ru.rsreu.exchangethings.controller.commands;

import ru.rsreu.exchangethings.helper.LoggerHelper;
import ru.rsreu.exchangethings.helper.LoginHelper;
import ru.rsreu.exchangethings.model.mock.TestLogging;
import ru.rsreu.exchangethings.view.CommonForwardView;
import ru.rsreu.exchangethings.view.ViewEnum;

public enum CommandsEnum {
    LOGIN {
        {
            command = new ActionViewCommand(ViewEnum.USER.getView(), ViewEnum.LOGIN.getView(), new LoginHelper(new TestLogging()));
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
