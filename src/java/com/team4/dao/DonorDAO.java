package com.team4.dao;

import com.team4.beans.Donor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.ConnectionDB;

public class DonorDAO {

    // Method to insert a new donor
    public boolean addDonor(Donor donor) {

        if (isDonorExists(donor.getdEmail(), donor.getdMobNo())) {
            // Return false if donor already exists, can also set a message here
            return false; // Indicate that the addition failed
        }
        String query = "INSERT INTO donor (d_id, d_name, d_email, d_mob, d_town_city, d_state, d_zip, d_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionDB.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, donor.getdId());
            statement.setString(2, donor.getdName());
            statement.setString(3, donor.getdEmail());
            statement.setString(4, donor.getdMobNo());
            statement.setString(5, donor.getdTown());
            statement.setString(6, donor.getdState());
            statement.setString(7, donor.getdZip());
            statement.setString(8, donor.getdPassword());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to check if a donor exists by email or mobile
    public boolean isDonorExists(String email, String mobile) {
        String query = "SELECT COUNT(*) FROM donor WHERE d_email = ? OR d_mob = ?";
        try (Connection connection = ConnectionDB.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setString(2, mobile);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Return true if at least one exists
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if no donor exists
    }

    // Method to validate a donor using email and password
    public Donor validateDonor(String email, String password) {
        Donor donor = null;
        String query = "SELECT * FROM donor WHERE d_email = ? AND d_password = ?";
        try (Connection connection = ConnectionDB.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                donor = new Donor();
                donor.setdId(rs.getString("d_id"));
                donor.setdName(rs.getString("d_name"));
                donor.setdEmail(rs.getString("d_email"));
                donor.setdMobNo(rs.getString("d_mob"));
                donor.setdTown(rs.getString("d_town_city"));
                donor.setdState(rs.getString("d_state"));
                donor.setdZip(rs.getString("d_zip"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donor;
    }

    // Method to find a donor by their ID
    public Donor findDonorById(String did) {
        String query = "SELECT * FROM donor WHERE d_id = ?";
        try (Connection connection = ConnectionDB.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, did);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Donor donor = new Donor();
                donor.setdId(rs.getString("d_id"));
                donor.setdName(rs.getString("d_name"));
                donor.setdEmail(rs.getString("d_email"));
                donor.setdMobNo(rs.getString("d_mob"));
                donor.setdTown(rs.getString("d_town_city"));
                donor.setdState(rs.getString("d_state"));
                donor.setdZip(rs.getString("d_zip"));
                donor.setdPassword(rs.getString("d_password"));
                return donor;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to find all donors
    public List<Donor> findAllDonors() {
        List<Donor> donorsList = new ArrayList<>();
        String query = "SELECT * FROM donor";
        try (Connection connection = ConnectionDB.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Donor donor = new Donor();
                donor.setdId(rs.getString("d_id"));
                donor.setdName(rs.getString("d_name"));
                donor.setdEmail(rs.getString("d_email"));
                donor.setdMobNo(rs.getString("d_mob"));
                donor.setdTown(rs.getString("d_town_city"));
                donor.setdState(rs.getString("d_state"));
                donor.setdZip(rs.getString("d_zip"));
                donorsList.add(donor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donorsList;
    }
}
