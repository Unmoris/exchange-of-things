package com.example.exchangethings.datalayer.entity;

public class Items {

    private int itemsID;
    private String title;
    private String image;
    private String description;
    private String publicationTime;
    private String userID;
    private String itemStatus;
    private String countView;

    public Items(int itemsID, String title, String image, String description, String publicationTime,
                 String userID, String itemStatus, String countView) {
        this.itemsID = itemsID;
        this.title = title;
        this.image = image;
        this.description = description;
        this.publicationTime = publicationTime;
        this.userID = userID;
        this.itemStatus = itemStatus;
        this.countView = countView;
    }

    public int getItemsID() {
        return itemsID;
    }

    public void setItemsID(int itemsID) {
        this.itemsID = itemsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getCountView() {
        return countView;
    }

    public void setCountView(String countView) {
        this.countView = countView;
    }
}
