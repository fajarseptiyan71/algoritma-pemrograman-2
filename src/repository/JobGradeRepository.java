package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.Database;
import model.JobGrade;

public class JobGradeRepository {
    public JobGrade getByCode(String code) throws SQLException {
        JobGrade jobGrade = null;
        String query = "SELECT * FROM job_grades WHERE code = ?";

        try (java.sql.Connection conn = Database.Connection()) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, code);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    jobGrade = new JobGrade(
                        rs.getInt("id"), 
                        rs.getString("code"), 
                        rs.getInt("amount")
                    );
                }
            }
        }

        return jobGrade;
    }
}
