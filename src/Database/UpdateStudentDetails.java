package Database;

import java.sql.*;

public class UpdateStudentDetails {

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/appproject",
                "root",
                "Dps3!2006"
        );
    }

    public void updateStudentDetails(String userId, String name, String phone, String age, String address) throws SQLException {
        try (Connection connection = connection()) {

            PreparedStatement ps1 = connection.prepareStatement(
                    "Select Student_Name, Student_Phone_Number, Student_Address, Student_Age from student where Reg_No = ?"
            );
            ps1.setString(1, userId);
            ResultSet rs1 = ps1.executeQuery();

            String oname = "", ophone = "", oaddress = "", oage = "";

            if (rs1.next()) {
                oname = rs1.getString("Student_Name");
                ophone = rs1.getString("Student_Phone_Number");
                oaddress = rs1.getString("Student_Address");
                oage = rs1.getString("Student_Age");
            }


            PreparedStatement res = connection.prepareStatement(
                    "Update attendance set Student_Name = ?, Student_Phone_Number = ?, Student_Address = ?, Student_Age = ? where userId = ? "
            );

            res.setString(1, name.isEmpty()? oname: name);
            res.setString(2, phone.isEmpty()? ophone: phone);
            res.setString(3, address.isEmpty()? oaddress: address);
            res.setString(4, age.isEmpty()? oage: age);
            res.setString(5, userId);

            res.executeQuery();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
