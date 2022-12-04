package ru.rsreu.exchangethings.view.beans;

public class ExchangeBean {

    private int id;
    private String timePublish;
    private String requestStatus;
    private String comment;
    private ItemBean senderItem;
    private ItemBean receiverItem;

    public ExchangeBean() {
    }

    public ExchangeBean(int id, String timePublish, String requestStatus, String comment, ItemBean senderItem, ItemBean receiverItem) {
        this.id = id;
        this.timePublish = timePublish;
        this.requestStatus = requestStatus;
        this.comment = comment;
        this.senderItem = senderItem;
        this.receiverItem = receiverItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimePublish() {
        return timePublish;
    }

    public void setTimePublish(String timePublish) {
        this.timePublish = timePublish;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ItemBean getSenderItem() {
        return senderItem;
    }

    public void setSenderItem(ItemBean senderItem) {
        this.senderItem = senderItem;
    }

    public ItemBean getReceiverItem() {
        return receiverItem;
    }

    public void setReceiverItem(ItemBean receiverItem) {
        this.receiverItem = receiverItem;
    }
}
