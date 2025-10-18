package Database;

import java.sql.*;

public class UpdateMarks {

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/appproject",
                "root",
                "Dps3!2006"
        );
    }

    public boolean updateAttendance(String userId, Double marks1, Double marks2, Double marks3) throws SQLException {
        try (Connection connection = connection()) {

            PreparedStatement ps = connection.prepareStatement(
                    "Select Subject_1_marks, Subject_2_marks, Subject_3_marks where userId = ?"
            );

            ps.setString(1, userId);
            ResultSet rs2 = ps.executeQuery();

            int sub1 = 0;
            int sub2 = 0;
            int sub3 = 0;

            if (rs2.next()) {
                sub1 = rs2.getInt("Subject_1_marks");
                sub2 = rs2.getInt("Subject_2_marks");
                sub3 = rs2.getInt("Subject_3_marks");
            }


            PreparedStatement res = connection.prepareStatement(
                    "Update attendance set Subject_1_marks = ?, Subject_2_marks = ?, Subject_3_marks = ? where userId = ? "
            );

            res.setDouble(1, (sub1+marks1)/2);
            res.setDouble(2, (sub2+marks2)/2);
            res.setDouble(3, (sub3+marks3)/2);
            res.setString(4, userId);

            res.executeQuery();

            return true;

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
