package Database;

import java.sql.*;

import ControllerFiles.*;

public class ControlLogin {

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/appproject",
                "root",
                "Dps3!2006"
        );
    }


    public boolean checkUserPassword(String username, String password, String usertype)
    {
        try(Connection connection = connection())
        {
            if(username.isEmpty() || password.isEmpty()) return false;
            PreparedStatement ps = connection.prepareStatement("SELECT Password_Hash FROM login WHERE User_Id = ? AND User_Type = ?");
            ps.setString(1, username);
            ps.setString(2, usertype);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                if(rs.getString("Password_Hash").equals(password)) return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
