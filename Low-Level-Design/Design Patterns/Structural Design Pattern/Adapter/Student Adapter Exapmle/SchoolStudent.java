
public class SchoolStudent {
    private String firstName;
    private String lastName;
    private String contactEmail;

    public SchoolStudent(String firstName, String lastName, String contactEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactEmail = contactEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactEmail() {
        return contactEmail;
    }
}