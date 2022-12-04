package ru.rsreu.exchangethings.view.parameters;

import ru.rsreu.exchangethings.controller.controls.commands.user.UserControlEnum;

public class UserActionBean {
    private String info = UserControlEnum.INFO.name();
    private String my_items = UserControlEnum.MY_ITEMS.name();
    private String exchange = UserControlEnum.EXCHANGE.name();
    private String list_items = UserControlEnum.LIST_ITEMS.name();
    private String item_adding = UserControlEnum.ITEM_ADDING.name();

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMy_items() {
        return my_items;
    }

    public void setMy_items(String my_items) {
        this.my_items = my_items;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getList_items() {
        return list_items;
    }

    public void setList_items(String list_items) {
        this.list_items = list_items;
    }

    public String getItem_adding() {
        return item_adding;
    }

    public void setItem_adding(String item_adding) {
        this.item_adding = item_adding;
    }
}
