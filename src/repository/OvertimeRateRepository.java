package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.Database;
import model.OvertimeRate;

public class OvertimeRateRepository {
    public OvertimeRate getByHour(Integer hour) throws SQLException {
        OvertimeRate overtimeRate = null;
        String query = "SELECT * FROM overtime_rates WHERE hour = ?";

        try (java.sql.Connection conn = Database.Connection()) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, hour);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    overtimeRate = new OvertimeRate(
                        rs.getInt("id"), 
                        rs.getInt("hour"), 
                        rs.getFloat("percentage")
                    );
                }
            }
        }

        return overtimeRate;
    }
}
