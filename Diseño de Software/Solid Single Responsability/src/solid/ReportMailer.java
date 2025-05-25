package solid;

public class ReportMailer {
    private String email;

    public ReportMailer (String email) {
        this.email = email;
    }

    public void sendByEmail(String email, Report report) {
        System.out.println("Sending report to " + email);
    }

}
