package ru.rsreu.exchangethings.model;

public enum UserRoleEnum{
    USER(1), MODERATOR(2), ADMIN(3);

    public final int order;

    UserRoleEnum(int order){
        this.order = order;
    }

    public static UserRoleEnum getRole(int orderInDatabase){
        UserRoleEnum userRoleEnum = USER;

        for (UserRoleEnum role: UserRoleEnum.values()) {
            if (role.order == orderInDatabase){
                userRoleEnum = role;
            }
        }

        return userRoleEnum;
    }
}
