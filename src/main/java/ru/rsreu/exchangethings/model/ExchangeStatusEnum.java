package ru.rsreu.exchangethings.model;

public enum ExchangeStatusEnum {
    ACTIVE(1), END(2), CANCEL(3);

    public final int order;

    ExchangeStatusEnum(int order) {
        this.order = order;
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
