package ru.rsreu.exchangethings.model.datalayer.entity;

import java.sql.Date;

public class RequestEntity {
    private int RequestID;
    private Date publicationTime;
    private int requestStatus;
    private String commentReceiver;
    private int itemSenderID;
    private int itemReceiverID;

    public RequestEntity(int requestID, Date publicationTime, int requestStatus, String commentReceiver, int itemSenderID, int itemReceiverID) {
        RequestID = requestID;
        this.publicationTime = publicationTime;
        this.requestStatus = requestStatus;
        this.commentReceiver = commentReceiver;
        this.itemSenderID = itemSenderID;
        this.itemReceiverID = itemReceiverID;
    }

    public int getRequestID() {
        return RequestID;
    }

    public void setRequestID(int requestID) {
        RequestID = requestID;
    }

    public Date getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(Date publicationTime) {
        this.publicationTime = publicationTime;
    }

    public int getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(int requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getCommentReceiver() {
        return commentReceiver;
    }

    public void setCommentReceiver(String commentReceiver) {
        this.commentReceiver = commentReceiver;
    }

    public int getItemSenderID() {
        return itemSenderID;
    }

    public void setItemSenderID(int itemSenderID) {
        this.itemSenderID = itemSenderID;
    }

    public int getItemReceiverID() {
        return itemReceiverID;
    }

    public void setItemReceiverID(int itemReceiverID) {
        this.itemReceiverID = itemReceiverID;
    }

    @Override
    public String toString() {
        return "RequestEntity{" +
                "RequestID=" + RequestID +
                ", publicationTime=" + publicationTime +
                ", requestStatus=" + requestStatus +
                ", commentReceiver='" + commentReceiver + '\'' +
                ", itemSenderID=" + itemSenderID +
                ", itemReceiverID=" + itemReceiverID +
                '}';
    }
}
