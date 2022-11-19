package com.example.exchangethings.datalayer.entity;

public class ItemStatus {
    private int itemStatusID;
    private String itemStatusName;

    public ItemStatus(int itemStatusID, String itemStatusName) {
        this.itemStatusID = itemStatusID;
        this.itemStatusName = itemStatusName;
    }

    public int getItemStatusID() {
        return itemStatusID;
    }

    public void setItemStatusID(int itemStatusID) {
        this.itemStatusID = itemStatusID;
    }

    public String getItemStatusName() {
        return itemStatusName;
    }

    public void setItemStatusName(String itemStatusName) {
        this.itemStatusName = itemStatusName;
    }
}
