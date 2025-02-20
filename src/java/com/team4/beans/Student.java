package com.team4.beans;

import java.util.Date;

public class Student {

    // Private fields matching the database columns
    private String sId;              // varchar(10), Primary Key
    private String sName;            // varchar(40), Not Null
    private Date sDob;               // date, Not Null
    private String sEmail;           // varchar(40), Not Null, Unique
    private String sMob;             // varchar(10), Not Null, Unique
    private String sZip;             // varchar(6), Not Null
    private String sVillageTown;     // varchar(40), Not Null
    private String sState;           // varchar(20), Not Null
    private String fatherName;       // varchar(40), Not Null
    private String motherName;       // varchar(40), Not Null
    private String familyIncome;     // varchar(40), Not Null
    private String fatherOccupation;  // varchar(40), Nullable
    private String motherOccupation;  // varchar(40), Nullable
    private String fatherMob;        // varchar(10), Nullable
    private String motherMob;        // varchar(10), Nullable
    private String currStudying;     // varchar(40), Not Null
    private String institute;         // varchar(50), Not Null
    private String regNo;            // varchar(20), Not Null
    private String sPassword;        // varchar(30), Not Null

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String sId, String sName, Date sDob, String sEmail, String sMob, String sZip, String sVillageTown,
                   String sState, String fatherName, String motherName, String familyIncome, String fatherOccupation,
                   String motherOccupation, String fatherMob, String motherMob, String currStudying, String institute,
                   String regNo, String sPassword) {
        this.sId = sId;
        this.sName = sName;
        this.sDob = sDob;
        this.sEmail = sEmail;
        this.sMob = sMob;
        this.sZip = sZip;
        this.sVillageTown = sVillageTown;
        this.sState = sState;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.familyIncome = familyIncome;
        this.fatherOccupation = fatherOccupation;
        this.motherOccupation = motherOccupation;
        this.fatherMob = fatherMob;
        this.motherMob = motherMob;
        this.currStudying = currStudying;
        this.institute = institute;
        this.regNo = regNo;
        this.sPassword = sPassword;
    }

    // Getters and Setters for each field
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Date getsDob() {
        return sDob;
    }

    public void setsDob(Date sDob) {
        this.sDob = sDob;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsMob() {
        return sMob;
    }

    public void setsMob(String sMob) {
        this.sMob = sMob;
    }

    public String getsZip() {
        return sZip;
    }

    public void setsZip(String sZip) {
        this.sZip = sZip;
    }

    public String getsVillageTown() {
        return sVillageTown;
    }

    public void setsVillageTown(String sVillageTown) {
        this.sVillageTown = sVillageTown;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFamilyIncome() {
        return familyIncome;
    }

    public void setFamilyIncome(String familyIncome) {
        this.familyIncome = familyIncome;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    public String getFatherMob() {
        return fatherMob;
    }

    public void setFatherMob(String fatherMob) {
        this.fatherMob = fatherMob;
    }

    public String getMotherMob() {
        return motherMob;
    }

    public void setMotherMob(String motherMob) {
        this.motherMob = motherMob;
    }

    public String getCurrStudying() {
        return currStudying;
    }

    public void setCurrStudying(String currStudying) {
        this.currStudying = currStudying;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    // Optional: Override toString() for easy logging or debugging
    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", sName='" + sName + '\'' +
                ", sDob=" + sDob +
                ", sEmail='" + sEmail + '\'' +
                ", sMob='" + sMob + '\'' +
                ", sZip='" + sZip + '\'' +
                ", sVillageTown='" + sVillageTown + '\'' +
                ", sState='" + sState + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", familyIncome='" + familyIncome + '\'' +
                ", fatherOccupation='" + fatherOccupation + '\'' +
                ", motherOccupation='" + motherOccupation + '\'' +
                ", fatherMob='" + fatherMob + '\'' +
                ", motherMob='" + motherMob + '\'' +
                ", currStudying='" + currStudying + '\'' +
                ", institute='" + institute + '\'' +
                ", regNo='" + regNo + '\'' +
                ", sPassword='" + sPassword + '\'' +
                '}';
    }
}
