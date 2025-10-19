package Database;

import java.sql.*;

public class UpdateTeacherDetails {

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/appproject",
                "root",
                "Dps3!2006"
        );
    }

    // Utility to fetch all teacher details at once
    private Teacher getTeacherDetails(String id) throws SQLException {
        try (Connection connection = connection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT Teacher_Name, Subject_Taught, Contact_No FROM teacher WHERE Teacher_ID = ?"
            );
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Teacher(
                        rs.getString("Teacher_Name"),
                        rs.getString("Subject_Taught"),
                        rs.getString("Contact_No")
                );
            }
            return null;
        }
    }

    public String getName(String id) {
        try {
            Teacher t = getTeacherDetails(id);
            return (t != null) ? t.name : "";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSubject(String id) {
        try {
            Teacher t = getTeacherDetails(id);
            return (t != null) ? t.subject : "";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getContact(String id) {
        try {
            Teacher t = getTeacherDetails(id);
            return (t != null) ? t.contact : "";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTeacherDetails(String userId, String name, String contact, String subject) {
        try {
            Teacher old = getTeacherDetails(userId);
            if (old == null) return;

            String newName = name.isEmpty() ? old.name : name;
            String newContact = contact.isEmpty() ? old.contact : contact;
            String newSubject = subject.isEmpty() ? old.subject : subject;

            try (Connection connection = connection()) {
                PreparedStatement ps = connection.prepareStatement(
                        "UPDATE attendance SET Teacher_Name = ?, Subject_Taught = ?, Contact_No = ? WHERE userId = ?"
                );
                ps.setString(1, newName);
                ps.setString(2, newSubject);
                ps.setString(3, newContact);
                ps.setString(4, userId);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Inner class for holding details
    private static class Teacher {
        String name, subject, contact;
        Teacher(String name, String subject, String contact) {
            this.name = name;
            this.subject = subject;
            this.contact = contact;
        }
    }
}
