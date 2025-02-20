package com.team4.beans;

public class Order {

    // Private fields matching the database columns
    private String orderId;        // varchar(10), Primary Key
    private String reqId;          // varchar(10), Foreign Key (nullable)
    private String lapId;          // varchar(10), Foreign Key (nullable)
    private String dId;        // varchar(10), Foreign Key (nullable)
    private String sId;      // varchar(10), Foreign Key (nullable)
    private String orderStatus;    // varchar(18), nullable

    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(String orderId, String reqId, String lapId, String dId, String sId, String orderStatus) {
        this.orderId = orderId;
        this.reqId = reqId;
        this.lapId = lapId;
        this.dId = dId;
        this.sId = sId;
        this.orderStatus = orderStatus;
    }

    // Getters and Setters for each field
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getLapId() {
        return lapId;
    }

    public void setLapId(String lapId) {
        this.lapId = lapId;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // Optional: Override toString() for easy logging or debugging
    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", reqId='" + reqId + '\'' +
                ", lapId='" + lapId + '\'' +
                ", dId='" + dId + '\'' +
                ", sId='" + sId + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
