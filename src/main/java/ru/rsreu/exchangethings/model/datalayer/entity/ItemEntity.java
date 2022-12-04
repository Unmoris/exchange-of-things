package ru.rsreu.exchangethings.model.datalayer.entity;

import java.sql.Date;

public class ItemEntity {

    private int itemsID;
    private String title;
    private String image;
    private String description;
    private Date publicationTime;
    private int userID;
    private String itemStatus;
    private int countView;

    public ItemEntity(int itemsID, String title, String image, String description, Date publicationTime,
                      int userID, String itemStatus, int countView) {
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

    public Date getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(Date publicationTime) {
        this.publicationTime = publicationTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public int getCountView() {
        return countView;
    }

    public void setCountView(int countView) {
        this.countView = countView;
    }
}
