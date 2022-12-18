package ru.rsreu.exchangethings.model;

public enum UserRoleEnum {
    ADMIN(1, "Администратор"), MODERATOR(2, "Модератор"), USER(3, "Пользователь");

    public final int order;
    public final String publicName;

    UserRoleEnum(int order, String publicName) {
        this.publicName = publicName;
        this.order = order;
    }

    public static UserRoleEnum getRole(int orderInDatabase) {
        UserRoleEnum userRoleEnum = USER;

        for (UserRoleEnum role : UserRoleEnum.values()) {
            if (role.order == orderInDatabase) {
                userRoleEnum = role;
            }
        }

        return userRoleEnum;
    }

    public static UserRoleEnum getRole(String publicName) {
        UserRoleEnum userRoleEnum = USER;

        for (UserRoleEnum role : UserRoleEnum.values()) {
            if (role.publicName.equals(publicName)) {
                userRoleEnum = role;
            }
        }

        return userRoleEnum;
    }
}
