package ru.rsreu.exchangethings.controller.commands;

import ru.rsreu.exchangethings.helper.LoggerHelper;
import ru.rsreu.exchangethings.helper.LoginHelper;
import ru.rsreu.exchangethings.model.mock.TestLogging;
import ru.rsreu.exchangethings.view.CommonForwardView;
import ru.rsreu.exchangethings.view.ViewEnum;

public enum CommandsEnum {
    LOGIN {
        {
            command = new ActionViewCommandCommonView(ViewEnum.TRUE.getView(), ViewEnum.LOGIN.getView(), new LoginHelper(new TestLogging()));
        }
    },
    INPUT {
        {
            command = new ActionViewCommandCommonView(ViewEnum.LOGIN.getView(), new LoggerHelper());
        }
    },
    LOGOUT {
        {
            command = new ActionViewCommandCommonView(new CommonForwardView(""), new LoggerHelper());
        }
    },
    EMPTY {
        {
            command = new ActionViewCommandCommonView(ViewEnum.EMPTY.getView(), new LoggerHelper());
        }
    }
//    MENU{
//        {
//            command = new ActionViewCommandCommonView(,new LoggerHelper());
//        }
//    }
    ;

    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
