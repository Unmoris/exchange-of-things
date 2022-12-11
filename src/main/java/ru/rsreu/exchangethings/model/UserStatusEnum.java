package ru.rsreu.exchangethings.model;

public enum UserStatusEnum {
    BLOCKED(1), NON_BLOCKED(2);
    public final int order;

    UserStatusEnum(int order) {
        this.order = order;
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
