package com.team4.dao;

import com.team4.beans.Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.ConnectionDB;

public class StudentDAO {

    // Method to insert a new student
    public boolean addStudent(Student student) {

        if (isStudentExists(student.getsEmail(), student.getsMob())) {
            // Return false if student already exists, can also set a message here
            return false; // Indicate that the addition failed
        }
        String query = "INSERT INTO Student (s_id, s_name, s_dob, s_email, s_mob, s_zip, s_village_town, s_state, father_name, mother_name, family_income, father_occupation, mother_occupation, father_mob, mother_mob, curr_studying, institute, reg_no, s_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, student.getsId());
            statement.setString(2, student.getsName());
            statement.setDate(3, (Date) student.getsDob());
            statement.setString(4, student.getsEmail());
            statement.setString(5, student.getsMob());
            statement.setString(6, student.getsZip());
            statement.setString(7, student.getsVillageTown());
            statement.setString(8, student.getsState());
            statement.setString(9, student.getFatherName());
            statement.setString(10, student.getMotherName());
            statement.setString(11, student.getFamilyIncome());
            statement.setString(12, student.getFatherOccupation());
            statement.setString(13, student.getMotherOccupation());
            statement.setString(14, student.getFatherMob());
            statement.setString(15, student.getMotherMob());
            statement.setString(16, student.getCurrStudying());
            statement.setString(17, student.getInstitute());
            statement.setString(18, student.getRegNo());
            statement.setString(19, student.getsPassword());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to check if a student already exists by email or mobile
    public boolean isStudentExists(String email, String mobile) {
        String query = "SELECT COUNT(*) FROM Student WHERE s_email = ? OR s_mob = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setString(2, mobile);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Return true if at least one exists
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if no student exists
    }

    // Method to validate student by email and password
    public Student validateStudent(String email, String password) {
        Student student = null;
        String query = "SELECT * FROM student WHERE s_email = ? AND s_password = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setsId(rs.getString("s_id"));
                student.setsName(rs.getString("s_name"));
                student.setsDob(rs.getDate("s_dob"));
                student.setsEmail(rs.getString("s_email"));
                student.setsMob(rs.getString("s_mob"));
                student.setsZip(rs.getString("s_zip"));
                student.setsVillageTown(rs.getString("s_village_town"));
                student.setsState(rs.getString("s_state"));
                student.setFatherName(rs.getString("father_name"));
                student.setMotherName(rs.getString("mother_name"));
                student.setFamilyIncome(rs.getString("family_income"));
                student.setFatherOccupation(rs.getString("father_occupation"));
                student.setMotherOccupation(rs.getString("mother_occupation"));
                student.setFatherMob(rs.getString("father_mob"));
                student.setMotherMob(rs.getString("mother_mob"));
                student.setCurrStudying(rs.getString("curr_studying"));
                student.setInstitute(rs.getString("institute"));
                student.setRegNo(rs.getString("reg_no"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // Method to find a student by their ID
    public Student findStudentById(String sId) {
        String query = "SELECT * FROM Student WHERE s_id=?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, sId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setsId(rs.getString("s_id"));
                student.setsName(rs.getString("s_name"));
                student.setsDob(rs.getDate("s_dob"));
                student.setsEmail(rs.getString("s_email"));
                student.setsMob(rs.getString("s_mob"));
                student.setsZip(rs.getString("s_zip"));
                student.setsVillageTown(rs.getString("s_village_town"));
                student.setsState(rs.getString("s_state"));
                student.setFatherName(rs.getString("father_name"));
                student.setMotherName(rs.getString("mother_name"));
                student.setFamilyIncome(rs.getString("family_income"));
                student.setFatherOccupation(rs.getString("father_occupation"));
                student.setMotherOccupation(rs.getString("mother_occupation"));
                student.setFatherMob(rs.getString("father_mob"));
                student.setMotherMob(rs.getString("mother_mob"));
                student.setCurrStudying(rs.getString("curr_studying"));
                student.setInstitute(rs.getString("institute"));
                student.setRegNo(rs.getString("reg_no"));
                student.setsPassword(rs.getString("s_password"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to find all students
    public List<Student> findAllStudents() {
        List<Student> studentsList = new ArrayList<>();
        String query = "SELECT * FROM Student";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setsId(rs.getString("s_id"));
                student.setsName(rs.getString("s_name"));
                student.setsDob(rs.getDate("s_dob"));
                student.setsEmail(rs.getString("s_email"));
                student.setsMob(rs.getString("s_mob"));
                student.setsZip(rs.getString("s_zip"));
                student.setsVillageTown(rs.getString("s_village_town"));
                student.setsState(rs.getString("s_state"));
                student.setFatherName(rs.getString("father_name"));
                student.setMotherName(rs.getString("mother_name"));
                student.setFamilyIncome(rs.getString("family_income"));
                student.setFatherOccupation(rs.getString("father_occupation"));
                student.setMotherOccupation(rs.getString("mother_occupation"));
                student.setFatherMob(rs.getString("father_mob"));
                student.setMotherMob(rs.getString("mother_mob"));
                student.setCurrStudying(rs.getString("curr_studying"));
                student.setInstitute(rs.getString("institute"));
                student.setRegNo(rs.getString("reg_no"));
                studentsList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsList;
    }
}
