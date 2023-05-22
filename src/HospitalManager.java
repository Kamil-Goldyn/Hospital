import java.util.List;
import java.util.Scanner;

public class HospitalManager {

    public static void main(String[] args) throws IllegalStateException {

        Scanner scanner = new Scanner(System.in);

        Doctor doctor = new Doctor("Ryszard","Wrzosek");
        System.out.println("Hello! Your name is " + doctor.getFirstName() + doctor.getLastName() +
                "\nToday in hospital are these patients: ");

        List<Patient> patients = Patient.getPatients();

        Patient.addNewPatient("Janusz","Kowalski");
        Patient.addNewPatient("Mariusz","Nowak");
        Patient.addNewPatient("Kamil","Wisniewski");
        Patient.addNewPatient("Maciej","Kowalczyk");
        Patient.addNewPatient("Mateusz","Lewandowski");
        Patient.addNewPatient("Dawid","Mazur");
        Patient.addNewPatient("Ewa","Kwiatkowska");
        Patient.addNewPatient("Anna","Krawczyk");
        Patient.addNewPatient("Julia","Kaczmarek");
        Patient.addNewPatient("Halina","Piotrowska");

        for (Patient p : patients) {
            System.out.println(p);
        }

        showMenu();
        int choice = scanner.nextInt();

        while (choice != 0) {
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the ID of the patient to cure: ");
                    int patientId = scanner.nextInt();
                    Patient selectedPatient = Patient.getPatientById(patientId);
                    if (selectedPatient != null) {
                        curePatient(selectedPatient);
                        showMenu();
                    } else {
                        System.out.println("Invalid patient ID");
                        showMenu();
                    }
                    choice = scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("Enter the ID of the patient to check status: ");
                    int patientId = scanner.nextInt();
                    Patient selectedPatient = Patient.getPatientById(patientId);
                    if (selectedPatient != null) {
                        System.out.println(selectedPatient);
                        showMenu();
                    } else {
                        System.out.println("Invalid patient ID");
                        showMenu();
                    }
                    choice = scanner.nextInt();
                }
                case 3 -> {
                    for (Patient p : patients) {
                        System.out.println(p);
                    }
                    showMenu();
                    choice = scanner.nextInt();
                }
                case 4 -> {
                    choice = 0;
                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    public static void curePatient(Patient patient) {
        List<Patient> patients = Patient.getPatients();
        if (patient.isCurable()) {
            patients.remove(patient);
        } else {
            System.out.println("You can not do that!");
        }
    }
    public static void showMenu() {
        System.out.println("""
                What would you like to do now?
                1. Try to cure your patients
                2. Check current patient status
                3. Check all your patients status\s
                4. Exit application""");
    }
}
