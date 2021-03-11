package learning.plainJdbc;

import java.sql.*;
import java.util.HashSet;
import java.util.LinkedList;

import org.postgresql.Driver;

public class Main {
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new Driver());
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qwerty123");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                long id = rs.getInt("student_id");
                String fullName = rs.getString("full_name");
                long facultyId = rs.getInt("faculty_id");
                System.out.println("id: " + id + " name: " + fullName + " faculty id: " + facultyId);
            }
            System.out.println();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
