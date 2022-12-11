package ru.rsreu.exchangethings.model;

public enum ItemStatusEnum {
    OPEN(1),
    HIDDEN(2),
    EXCHANGED(3),
    BLOCKED(4);
    public final int order;

    ItemStatusEnum(int order) {
        this.order = order;
    }

    public static ItemStatusEnum getStatus(int orderInDatabase) {
        ItemStatusEnum userRoleEnum = OPEN;
        for (ItemStatusEnum roleEnum : ItemStatusEnum.values()) {
            if (roleEnum.order == orderInDatabase) {
                userRoleEnum = roleEnum;
            }
        }
        return userRoleEnum;
    }
}
