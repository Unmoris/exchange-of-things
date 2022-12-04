package ru.rsreu.exchangethings.view.parameters;

import ru.rsreu.exchangethings.controller.controls.commands.CommandsControlEnum;

public class CommandActionsBean {

    private String login = CommandsControlEnum.LOGIN.name();
    private String input = CommandsControlEnum.INPUT.name();
    private String logout = CommandsControlEnum.LOGOUT.name();
    private String empty = CommandsControlEnum.EMPTY.name();
    private String user = CommandsControlEnum.USER.name();


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }

    public String getEmpty() {
        return empty;
    }

    public void setEmpty(String empty) {
        this.empty = empty;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
