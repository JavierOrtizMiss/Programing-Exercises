package modelo;

public class Person {
    private String name;
    private  int employeeID;
    private String title;
    private ContactInformation contactInformation;

    public Person(String name, int employeeID, String title) {
        this.name = name;
        this.employeeID = employeeID;
        this.title = title;
        this.contactInformation = contactInformation;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }



}
