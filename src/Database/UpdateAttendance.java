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

    public void updateAttendance(String userId, boolean status1, boolean status2, boolean status3) throws SQLException {
        try (Connection connection = connection()) {

            PreparedStatement ps1 = connection.prepareStatement(
                    "Select Subject_1_hours, Subject_2_hours, Subject_3_hours from attendance where UserId = ?"
            );
            ps1.setString(1, userId);
            ResultSet rs1 = ps1.executeQuery();

            int subject1 = 0;
            int subject2 = 0;
            int subject3 = 0;

            if (rs1.next()) {
                subject1 = rs1.getInt("Subject_1_hours");
                subject2 = rs1.getInt("Subject_2_hours");
                subject3 = rs1.getInt("Subject_3_hours");
            }


            PreparedStatement ps2 = connection.prepareStatement(
                    "Select Subject_1_hours_present, Subject_2_hours_present, Subject_3_hours_present from attendance where UserId = ?"
            );
            ps2.setString(1, userId);

            ResultSet rs2 = ps2.executeQuery();

            int subject1attended = 0;
            int subject2attended = 0;
            int subject3attended = 0;

            if (rs2.next()) {
                subject1attended = rs2.getInt("Subject_1_hours_present");
                subject2attended = rs2.getInt("Subject_2_hours_present");
                subject3attended = rs2.getInt("Subject_3_hours_present");
            }


            PreparedStatement res = connection.prepareStatement(
                    "Update attendance set subject_1_hours = ?, subject_2_hours = ?, subject_3_hours = ?, subject_1_hours_present = ?, subject_2_hours_present = ?, subject_3_hours_present = ? where userId = ? "
            );
            res.setInt(1, ++subject1);
            res.setInt(2, ++subject2);
            res.setInt(3, ++subject3);
            res.setInt(4, status1 ? ++subject1attended: subject1attended);
            res.setInt(5, status2 ? ++subject2attended: subject2attended);
            res.setInt(6, status3 ? ++subject3attended: subject3attended);
            res.setString(7, userId);

            res.executeQuery();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
