package com.team4.dao;

import com.team4.beans.Requests;
import utils.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {

    // Find a request by its ID
    public static List<Requests> findRequestById(String sId) {
        List<Requests> requests = new ArrayList<>(); // Initialize the list

        String sql = "SELECT * FROM request WHERE s_id = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Requests req = new Requests();
                req.setReqId(rs.getString("req_id"));
                req.setsId(rs.getString("s_id"));
                req.setLapId(rs.getString("lap_id"));
                req.setReqDate(java.sql.Date.valueOf(rs.getString("req_date")));
                req.setReqStatus(rs.getString("req_status"));
                requests.add(req);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    

    // Retrieve all requests
    public static List<Requests> findAllRequests() {
        List<Requests> requests = new ArrayList<>();
        String sql = "SELECT * FROM request";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Requests request = new Requests();
                request.setReqId(rs.getString("req_id"));
                request.setsId(rs.getString("s_id"));
                request.setLapId(rs.getString("lap_id"));
                request.setReqDate(java.sql.Date.valueOf(rs.getString("req_date")));
                request.setReqStatus(rs.getString("req_status"));
                requests.add(request);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

}
