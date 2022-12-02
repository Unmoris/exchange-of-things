package ru.rsreu.exchangethings.model.datalayer.entity;

public class RequestEntity {
    private int RequestID;
    private String publicationTime;
    private int requestStatusID;
    private String commentReceiver;
    private int itemSenderID;
    private int itemReceiverID;

    public RequestEntity(int requestID, String publicationTime, int requestStatusID, String commentReceiver, int itemSenderID, int itemReceiverID) {
        RequestID = requestID;
        this.publicationTime = publicationTime;
        this.requestStatusID = requestStatusID;
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

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }

    public int getRequestStatusID() {
        return requestStatusID;
    }

    public void setRequestStatusID(int requestStatusID) {
        this.requestStatusID = requestStatusID;
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
}
