package ru.rsreu.exchangethings.view.parameters;

public class ActionBean implements ControlNames {
    private String command = this.CONTROL_COMMAND;

    private String user = this.CONTROL_USER;
    private String admin = this.CONTROL_ADMIN;


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

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
