package com.team4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.team4.beans.Laptop;
import com.team4.beans.Requests;
import utils.ConnectionDB;

public class LaptopDAO {

    public static boolean insertLaptop(Laptop laptop) {
        String query = "INSERT INTO Laptop (lap_id, brand, processor, ram, storage, no_of_devices, d_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            
            pst.setString(1, laptop.getlapId());
            pst.setString(2, laptop.getBrand());
            pst.setString(3, laptop.getProcessor());
            pst.setString(4, laptop.getRam());
            pst.setString(5, laptop.getStorage());
            pst.setInt(6, laptop.getNoOfDevices());
            pst.setString(7, laptop.getdId());

            return pst.executeUpdate() > 0; // Returns true if insert is successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Find a laptop by its ID
    public static Laptop findLaptopById(String lapId) {
        String query = "SELECT * FROM Laptop WHERE lap_id=?";
        Laptop laptop = null;
        try (Connection con = ConnectionDB.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, lapId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                laptop = new Laptop(
                        rs.getString("lap_id"),
                        rs.getString("brand"),
                        rs.getString("processor"),
                        rs.getString("ram"),
                        rs.getString("storage"),
                        rs.getInt("no_of_devices"),
                        rs.getString("d_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptop;
    }
    
    // Find a laptop by its ID
   public static int getAvailableStock(String lapId) {
    String query = "SELECT no_of_devices FROM Laptop WHERE lap_id=?";
    int availableStock = 0;

    try (Connection con = ConnectionDB.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {
        pst.setString(1, lapId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            availableStock = rs.getInt("no_of_devices");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return availableStock;
}


    // Find all laptops
    public static List<Laptop> findAllLaptops() {
        String query = "SELECT * FROM Laptop";
        List<Laptop> laptops = new ArrayList<>();
        try (Connection con = ConnectionDB.getConnection(); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Laptop laptop = new Laptop(
                        rs.getString("lap_id"),
                        rs.getString("brand"),
                        rs.getString("processor"),
                        rs.getString("ram"),
                        rs.getString("storage"),
                        rs.getInt("no_of_devices"),
                        rs.getString("d_id")
                );
                laptops.add(laptop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }
}