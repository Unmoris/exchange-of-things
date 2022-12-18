package ru.rsreu.exchangethings.model;

public enum ExchangeStatusEnum {
    ACTIVE(1, "Открыта"),
    END(2, "Закрыта"),
    CANCEL(3, "Отменена");

    public final int order;
    public final String publicName;

    ExchangeStatusEnum(int order, String publicName) {
        this.order = order;
        this.publicName = publicName;
    }

    public static ExchangeStatusEnum getStatus(int orderInDatabase) {
        ExchangeStatusEnum userRoleEnum = ACTIVE;
        for (ExchangeStatusEnum roleEnum : ExchangeStatusEnum.values()) {
            if (roleEnum.order == orderInDatabase) {
                userRoleEnum = roleEnum;
            }
        }
        return userRoleEnum;
    }

}
