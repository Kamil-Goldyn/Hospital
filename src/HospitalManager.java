import java.util.List;
import java.util.Scanner;

public class HospitalManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Doctor doctor = new Doctor("Ryszard","Wrzosek");
        System.out.println("Hello! Your name is " + doctor.getFirstName() + doctor.getLastName() +
                "\nToday in hospital are these patients: ");

        List<Patient> patients = Patient.getPatients();

        Patient.addNewPatient("Janusz","Kowalski",40);
        Patient.addNewPatient("Mariusz","Nowak",40);
        Patient.addNewPatient("Kamil","Wisniewski",40);
        Patient.addNewPatient("Maciej","Kowalczyk",40);
        Patient.addNewPatient("Mateusz","Lewandowski",40);
        Patient.addNewPatient("Dawid","Mazur",40);
        Patient.addNewPatient("Ewa","Kwiatkowska",40);
        Patient.addNewPatient("Anna","Krawczyk",40);
        Patient.addNewPatient("Julia","Kaczmarek",40);
        Patient.addNewPatient("Halina","Piotrowska",40);

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
            }
        }
    }

    public static void curePatient(Patient patient) {
        if (patient.isCurable()) {
            List<Patient> patients = Patient.getPatients();
            patients.remove(patient);
        } else {
            System.out.println("You can not do that! You have to wait for the rest of hospitalization time (go home to advance time by one day)");
        }
    }
    public static void showMenu() {
        System.out.println("What would you like to do now?" +
                "\n1. Try to cure your patients" +
                "\n2. Check current patient status" +
                "\n3. Check all your patients status " +
                "\n4. Go home (advances time by 1 day) " +
                "\n5. Exit application");
    }
}
