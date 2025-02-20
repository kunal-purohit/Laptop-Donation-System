package com.team4.beans;

import java.util.Date;

public class Requests {

    // Private fields matching the database columns
    private String reqId;        // varchar(10), Primary Key
    private String sId;    // varchar(10), Foreign Key (nullable)
    private String lapId;        // varchar(10), Foreign Key (nullable)
    private Date reqDate;        // Date, nullable
    private String reqStatus;    // varchar(8), nullable

    // Default constructor
    public Requests() {
    }

    // Parameterized constructor
    public Requests(String reqId, String sId, String lapId, Date reqDate, String reqStatus) {
        this.reqId = reqId;
        this.sId = sId;
        this.lapId = lapId;
        this.reqDate = reqDate;
        this.reqStatus = reqStatus;
    }

    // Getters and Setters for each field
    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getLapId() {
        return lapId;
    }

    public void setLapId(String lapId) {
        this.lapId = lapId;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    // Optional: Override toString() for easy logging or debugging
    @Override
    public String toString() {
        return "Request{" +
                "reqId='" + reqId + '\'' +
                ", sId='" + sId + '\'' +
                ", lapId='" + lapId + '\'' +
                ", reqDate=" + reqDate +
                ", reqStatus='" + reqStatus + '\'' +
                '}';
    }
}
