package solid;

public class ReportGenerator {
    public void generateReport(Report report) {
        System.out.println("Generating report: " + report.getTitle());
        System.out.println(report.getContent());
        
    }
}
