package ru.rsreu.exchangethings.model;

public enum ItemStatusEnum {
    OPEN(1, "Открыта"),
    HIDDEN(2, "Скрыта"),
    EXCHANGED(3, "Обменена"),
    BLOCKED(4, "Заблокирована");
    public final int order;
    public final String publicName;

    ItemStatusEnum(int order, String publicName) {
        this.order = order;
        this.publicName = publicName;
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
