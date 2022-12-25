package ru.rsreu.exchangethings.view.beans;

import ru.rsreu.exchangethings.model.ItemStatusEnum;
import ru.rsreu.exchangethings.model.datalayer.entity.ItemEntity;

import java.io.Serializable;
import java.sql.Date;

public class ItemBean implements Serializable {
    private int id;
    private String title;
    private String image;
    private String description;
    private boolean isHidden;
    private UserBean owner;
    private String status;
    private Date publishTime;
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

    public ItemBean(int id, String title, String image, String description, UserBean owner, Date publishTime, int countViewItem) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.owner = owner;
        this.publishTime = publishTime;
        this.countViewItem = countViewItem;
    }
    public ItemBean(ItemEntity itemEntity, UserBean owner){
        this.id = itemEntity.getItemsID();
        this.title = itemEntity.getTitle();
        this.image = itemEntity.getImage();
        this.description = itemEntity.getDescription();
        this.status = ItemStatusEnum.getStatus(itemEntity.getItemStatus()).publicName;
        this.owner = owner;
        this.isHidden = ItemStatusEnum.getStatus(itemEntity.getItemStatus()) == ItemStatusEnum.HIDDEN;
        this.publishTime = itemEntity.getPublicationTime();
        this.countViewItem = itemEntity.getCountView();
    }

    public ItemBean(ItemEntity itemEntity){
        this.id = itemEntity.getItemsID();
        this.title = itemEntity.getTitle();
        this.image = itemEntity.getImage();
        this.isHidden = ItemStatusEnum.getStatus(itemEntity.getItemStatus()) == ItemStatusEnum.HIDDEN;
        this.description = itemEntity.getDescription();
        this.publishTime = itemEntity.getPublicationTime();
        this.countViewItem = itemEntity.getCountView();
        this.status = ItemStatusEnum.getStatus(itemEntity.getItemStatus()).publicName;
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

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
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
