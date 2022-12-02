package ru.rsreu.exchangethings.view.parameters;

public class ActionBean implements ControlNames {
    private String command = this.CONTROL_COMMAND;

    private String user = this.CONTROL_USER;


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
