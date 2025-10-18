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

    public void updateTeacherDetails(String userId, String name, String contact, String subject) throws SQLException {
        try (Connection connection = connection()) {

            PreparedStatement ps1 = connection.prepareStatement(
                    "Select Teacher_Name, Subject_Taught, Contact_No from teacher where Teacher_ID = ?"
            );

            ps1.setString(1, userId);
            ResultSet rs1 = ps1.executeQuery();

            String oname = "", osubject = "", oContact = "";

            if (rs1.next()) {
                oname = rs1.getString("Teacher_Name");
                osubject = rs1.getString("Subject_Taught");
                oContact = rs1.getString("Contact_No");
            }


            PreparedStatement res = connection.prepareStatement(
                    "Update attendance set Teacher_Name = ?, Subject_Taught = ?, Contact_No = ? where userId = ? "
            );

            res.setString(1, name.isEmpty()? oname: name);
            res.setString(1, contact.isEmpty()? oContact: contact);
            res.setString(1, subject.isEmpty()? osubject: subject);

            res.executeQuery();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
