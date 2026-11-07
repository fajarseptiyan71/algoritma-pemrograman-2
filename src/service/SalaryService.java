package service;

import model.JobGrade;
import model.OvertimeRate;

public class SalaryService {
    public static Integer Calculate(JobGrade jobGrade, OvertimeRate overtimeRate) {
        return (int) (jobGrade.getAmount() * overtimeRate.getPercentage());
    }
}
