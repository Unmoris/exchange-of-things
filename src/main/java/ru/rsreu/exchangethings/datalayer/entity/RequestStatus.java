package com.example.exchangethings.datalayer.entity;

public class RequestStatus {

    private int requestStatusID;
    private String requestStatusName;

    public RequestStatus(int requestStatusID, String requestStatusName) {
        this.requestStatusID = requestStatusID;
        this.requestStatusName = requestStatusName;
    }

    public int getRequestStatusID() {
        return requestStatusID;
    }

    public void setRequestStatusID(int requestStatusID) {
        this.requestStatusID = requestStatusID;
    }

    public String getRequestStatusName() {
        return requestStatusName;
    }

    public void setRequestStatusName(String requestStatusName) {
        this.requestStatusName = requestStatusName;
    }
}
