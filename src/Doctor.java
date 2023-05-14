public class Doctor implements Authorizator{
    private String firstName;
    private String lastName;
    private String title = "dr";
    private double salary = 6500;

    public Doctor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName + " ";
    }

    public String getLastName() {
        return lastName + " ";
    }

    public String getTitle() {
        return title;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean canCheckHealthStatus() {
        return true;
    }

    @Override
    public boolean canCureOthers() {
        return true;
    }

    @Override
    public String toString() {
        return "Doctor: " +
                firstName + " " +
                lastName + " " +
                ", title: " + title +
                ", salary: " + salary;
    }
}
