package ru.rsreu.exchangethings.model;

public enum UserStatusEnum {
    NON_BLOCKED(1, "Не заблокирован"), BLOCKED(2, "Заблокирован");
    public final int order;
    public final String publicName;

    UserStatusEnum(int order, String publicName) {
        this.order = order;
        this.publicName = publicName;
    }

    public static UserStatusEnum getStatus(int orderInDatabase) {
        UserStatusEnum userRoleEnum = BLOCKED;
        for (UserStatusEnum roleEnum : UserStatusEnum.values()) {
            if (roleEnum.order == orderInDatabase) {
                userRoleEnum = roleEnum;
            }
        }
        return userRoleEnum;
    }

}
