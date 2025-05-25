package solid;

public class ReportSaver {
    private String filename;

    public ReportSaver(String filename) {
        this.filename = filename;
    }

    public String saveFile(String filename, Report report) {
        System.out.println("Saving report to file: " + filename);
    }

}
