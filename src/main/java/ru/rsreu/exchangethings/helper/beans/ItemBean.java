package ru.rsreu.exchangethings.helper.beans;

import java.io.Serializable;

public class ItemBean implements Serializable {
    private int id;
    private String name;
    private String image;
    private String description;
    private String owner;
    private String status;
    private int count;

    public int getId() {
        return id;
    }

    public ItemBean() {
    }

    public ItemBean(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
