import java.util.*;

public class Patient implements Authorizator{
    private final String firstName;
    private final String lastName;
    private final int id;
    private static int patientId = 0;
    private final int age;
    private int hospitalizationPeriod;
    private Diseases disease;
    private static final List<Patient> patients = new LinkedList<>();

    private Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = patientId;
        Random random = new Random();
        int number = random.nextInt((4));
        int lowerBound = 18;
        int upperBound = 90;
        this.age = random.nextInt(upperBound-lowerBound + 1) + lowerBound;

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

    public static Patient addNewPatient(String firstName, String lastName) {
        Patient patient = new Patient(firstName, lastName);
        patients.add(patient);
        return patient;
    }

    public static List<Patient> getPatients() {
        patients.removeIf(p -> p.getHospitalizationPeriod() == 0);
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
        return "Patient: " + firstName + " " + lastName +
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
