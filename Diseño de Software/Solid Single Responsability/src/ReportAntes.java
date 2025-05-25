public class Report {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void generateReport() {
        System.out.println("Generating report: " + title);
        System.out.println(content);
    }

    public void saveFile(String filename){
        System.out.println("Saving report to file: " + filename);
    }

    public void sendByEmail(String email){
        System.out.println("Sending report to " + email);
    }
}
