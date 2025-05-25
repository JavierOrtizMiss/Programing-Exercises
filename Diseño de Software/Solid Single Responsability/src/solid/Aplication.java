import solid.*;

public class Aplication {
    public static void main(String[] args) {
        Report report = new Report("Reporte semanal", "Cntenido del reporte semanal");

        ReportGenerator generator = new ReportGenerator();
        generator.generateReport(report);

        ReportSaver saver = new ReportSaver("report.txt");
        saver.saveFile("report.txt", report);

        ReportMailer mailer = new ReportMailer("example@example.com");
        mailer.sendByEmail("example@example.com", report);
    }
}
