package ru.rsreu.exchangethings.view.beans;

import java.io.Serializable;
import java.time.LocalTime;

public class ItemBean implements Serializable {
    private int id;
    private String title;
    private String image;
    private String description;


    private boolean isHidden;
    private UserBean owner;
    private String status;

    private LocalTime publishTime;
    private int countViewItem;

    public int getId() {
        return id;
    }

    public ItemBean() {
    }

    public ItemBean(String name, String image, String description) {
        this.title = name;
        this.image = image;
        this.description = description;
    }

    public ItemBean(String name, String image, String description, UserBean owner) {
        this.title = name;
        this.image = image;
        this.description = description;
        this.owner = owner;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserBean getOwner() {
        return owner;
    }

    public void setOwner(UserBean owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalTime publishTime) {
        this.publishTime = publishTime;
    }

    public int getCountViewItem() {
        return countViewItem;
    }

    public void setCountViewItem(int countViewItem) {
        this.countViewItem = countViewItem;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean hidden) {
        isHidden = hidden;
    }
}
