import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Patient implements Authorizator{
    private final String firstName;
    private final String lastName;
    private final int id;
    private static int patientId = 0;
    private final int age;
    private int hospitalizationPeriod;
    private Diseases disease;
    private final Random random = new Random();
    private static List<Patient> patients = new LinkedList<>();

    private Patient(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = patientId;
        int number = random.nextInt((4));

        switch (number) {
            case 0 -> this.disease = Diseases.HEADACHE;
            case 1 -> this.disease = Diseases.BLEEDING;
            case 2 -> this.disease = Diseases.BROKENARM;
            case 3 -> this.disease = Diseases.UNCONSCIOUS;
        }
        switch (disease) {
            case HEADACHE -> this.hospitalizationPeriod = 1;
            case BLEEDING -> this.hospitalizationPeriod = 2;
            case BROKENARM -> this.hospitalizationPeriod = 4;
            case UNCONSCIOUS -> this.hospitalizationPeriod = 8;
        }
        patientId++;
    }

    public static Patient addNewPatient(String firstName, String lastName, int age) {
        Patient patient = new Patient(firstName, lastName, age);
        patients.add(patient);
        return patient;
    }

    public static List<Patient> getPatients() {
        return patients;
    }

    public static Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public String getFirstName() {
        return firstName + " ";
    }

    public String getLastName() {
        return lastName + " ";
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public int getHospitalizationPeriod() {
        if (hospitalizationPeriod == 1) {
            System.out.print("Number of weeks this patient is going to spend in the hospital: ");
        } else if (hospitalizationPeriod == 2) {
            System.out.print("Number of weeks this patient is going to spend in the hospital: ");
        } else if (hospitalizationPeriod == 4) {
            System.out.print("Number of weeks this patient is going to spend in the hospital: ");
        } else if (hospitalizationPeriod == 8) {
            System.out.print("Number of weeks this patient is going to spend in the hospital: ");
        }
        return hospitalizationPeriod;
    }

    @Override
    public String toString() {
        return "Patient: " +
                "" + firstName + " " +
                "" + lastName +
                ", patient ID: " + id +
                ", age: " + age +
                ", number of weeks to spend in hospital yet: " + hospitalizationPeriod +
                ", diagnosed disease: " + disease;
    }

    public boolean isCurable() {
        return disease != Diseases.UNCONSCIOUS;
    }

    @Override
    public boolean canCheckHealthStatus() {
        return true;
    }

    @Override
    public boolean canCureOthers() {
        return false;
    }
}
