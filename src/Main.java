import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import model.JobGrade;
import model.OvertimeRate;
import repository.JobGradeRepository;
import repository.OvertimeRateRepository;
import service.SalaryService;

public class Main {

    public static void main(String[] args) {
        Locale lang = Locale.of("id", "ID");
        NumberFormat idrFormat = NumberFormat.getCurrencyInstance(lang);

        JobGradeRepository jobGradeRepo = new JobGradeRepository();
        OvertimeRateRepository overtimeRateRepo = new OvertimeRateRepository();

       try (Scanner scan = new Scanner(System.in)) {
        System.out.print("Masukan Golongan: ");
        String inputGrade = scan.nextLine().trim().toUpperCase();

        JobGrade jobGrade = jobGradeRepo.getByCode(inputGrade);
        if (jobGrade == null) {
            System.out.println("Data tidak ditemukan!");
            return;
        }

        System.out.print("Masukan Durasi: ");
        if (!scan.hasNextInt()) {
            System.out.println("Format tidak valid!");
            return;
        }

        Integer inputDuration = scan.nextInt();
        
        if (inputDuration > 5) {
            inputDuration = 5;
        }

        OvertimeRate overtimeRate = overtimeRateRepo.getByHour(inputDuration);
        if (overtimeRate == null) {
            System.out.println("Data tidak ditemukan!");
            return;
        }

        Integer salary = SalaryService.Calculate(jobGrade, overtimeRate);
        System.out.println("Gaji pokok : " + idrFormat.format(jobGrade.getAmount()));
        System.out.println("Gaji Lembur : " + idrFormat.format(salary));
        System.out.println("Total Gaji : " + idrFormat.format(salary + jobGrade.getAmount()));

       } catch (SQLException e) {
        System.out.println("Database error: " + e.getMessage());
       }
    }
}
