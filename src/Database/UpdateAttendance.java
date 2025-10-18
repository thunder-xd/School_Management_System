package Database;

import java.sql.*;

import Backend.*;

public class UpdateAttendance {

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/appproject",
                "root",
                "Dps3!2006"
        );
    }

    public boolean updateAttendance(String userId, boolean status1, boolean status2, boolean status3) throws SQLException {
        try (Connection connection = connection()) {

            if(userId.isEmpty()) return false;



            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                if(rs.getString("Password").equals(password)) return true;
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
