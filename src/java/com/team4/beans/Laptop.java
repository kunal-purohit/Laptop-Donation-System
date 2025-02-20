package com.team4.beans;

public class Laptop{

    // Private fields matching your database columns
    private String lapId;         // varchar(10), Primary Key
    private String brand;       // varchar(45)
    private String processor;   // varchar(45)
    private String ram;         // varchar(45)
    private String storage;     // varchar(45)
    private int noOfDevices;     // int
    private String donorId;         // varchar(10), Foreign Key (optional)

    // Default constructor
    public Laptop() {
    }

    // Parameterized constructor
    public Laptop(String lapId, String brand, String processor, String ram, String storage, int noOfDevices, String donorId) {
        this.lapId = lapId;
        this.brand = brand;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.noOfDevices = noOfDevices;
        this.donorId = donorId;
    }

    // Getters and Setters for each field
    public String getlapId() {
        return lapId;
    }

    public void setlapId(String lapId) {
        this.lapId = lapId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public int getNoOfDevices() {
        return noOfDevices;
    }

    public void setNoOfDevices(int noOfDevices) {
        this.noOfDevices = noOfDevices;
    }

    public String getdId() {
        return donorId;
    }

    public void setdId(String donorId) {
        this.donorId = donorId;
    }

    // Optional: Override toString() for easy logging or debugging
    @Override
    public String toString() {
        return "LaptopBean{" +
                "lapId = '" + lapId + '\'' +
                ", brand = '" + brand + '\'' +
                ", processor = '" + processor + '\'' +
                ", ram = '" + ram + '\'' +
                ", storage = '" + storage + '\'' +
                ", noOfDevice = '" + noOfDevices + '\'' +
                ", donorId = '" + donorId + '\'' +
                '}';
    }
}