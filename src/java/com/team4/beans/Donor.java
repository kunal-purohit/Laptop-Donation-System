package com.team4.beans;

public class Donor {

    private String dId;     
    private String dName;   
    private String dEmail;    
    private String dMobNo;   
    private String dTown;     
    private String dState;   
    private String dZip;     
    private String dPassword;

    public Donor(){  
    }
    
    public Donor(String dId, String dName, String dEmail, String dMobNo, String dTown, String dState, String dZip, String dPassword) {
        this.dId = dId;
        this.dName = dName;
        this.dEmail = dEmail;
        this.dMobNo = dMobNo;
        this.dTown = dTown;
        this.dState = dState;
        this.dZip = dZip;
        this.dPassword = dPassword;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdEmail() {
        return dEmail;
    }

    public void setdEmail(String dEmail) {
        this.dEmail = dEmail;
    }

    public String getdMobNo() {
        return dMobNo;
    }

    public void setdMobNo(String dMobNo) {
        this.dMobNo = dMobNo;
    }

    public String getdTown() {
        return dTown;
    }

    public void setdTown(String dTown) {
        this.dTown = dTown;
    }

    public String getdState() {
        return dState;
    }

    public void setdState(String dState) {
        this.dState = dState;
    }

    public String getdZip() {
        return dZip;
    }

    public void setdZip(String dZip) {
        this.dZip = dZip;
    }

    public String getdPassword() {
        return dPassword;
    }

    public void setdPassword(String dPassword) {
        this.dPassword = dPassword;
    }

    @Override
    public String toString() {
        return "DonorBean{" +
                "dId='" + dId + '\'' +
                ", dName='" + dName + '\'' +
                ", dEmail='" + dEmail + '\'' +
                ", dMobNo='" + dMobNo + '\'' +
                ", dTown='" + dTown + '\'' +
                ", dState='" + dState + '\'' +
                ", dZip='" + dZip + '\'' +
                ", dPassword='" + dPassword + '\'' +
                '}';
    }
}