package ru.rsreu.exchangethings.view.parameters;

public class ActionBean implements ControlNames {
    private String command = this.CONTROL_COMMAND;

    private String user = this.CONTROL_USER;
    private String admin = this.CONTROL_ADMIN;
    private String moderator = this.CONTROL_MODERATOR;

    public String getModerator() {
        return moderator;
    }

    public void setModerator(String moderator) {
        this.moderator = moderator;
    }

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
