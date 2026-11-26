
package hospital;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // Read Integer Safely
    public static int readInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                int value = sc.nextInt();
                sc.nextLine();
                return value;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer!");
                sc.nextLine();
            }
        }
    }

    // Read Double Safely
    public static double readDouble(String message) {

        while (true) {
            try {
                System.out.print(message);
                double value = sc.nextDouble();
                sc.nextLine();
                return value;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid amount!");
                sc.nextLine();
            }
        }
    }

    // Read Text
    public static String readText(String message) {

        System.out.print(message);
        return sc.nextLine().trim();
    }

    public static void main(String[] args) {

        HospitalService service = new HospitalService();

        int choice;

        do {

            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. View Patients");
            System.out.println("4. View Doctors");
            System.out.println("5. Search Patient");
            System.out.println("6. Search Doctor");
            System.out.println("7. Update Patient");
            System.out.println("8. Delete Patient");
            System.out.println("9. Book Appointment");
            System.out.println("10. View Appointments");
            System.out.println("11. Generate Bill");
            System.out.println("12. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:

                    int pid = readInt("Enter Patient ID: ");
                    String pname = readText("Enter Name: ");
                    int page = readInt("Enter Age: ");
                    String pgender = readText("Enter Gender: ");
                    String disease = readText("Enter Disease: ");

                    Patient patient = new Patient(
                        pid, pname, page, pgender, disease
                    );

                    service.addPatient(patient);
                    break;

                case 2:

                    int did = readInt("Enter Doctor ID: ");
                    String dname = readText("Enter Name: ");
                    int dage = readInt("Enter Age: ");
                    String dgender = readText("Enter Gender: ");
                    String specialization =
                        readText("Enter Specialization: ");

                    double fee = readDouble(
                        "Enter Consultation Fee: "
                    );

                    Doctor doctor = new Doctor(
                        did, dname, dage, dgender,
                        specialization, fee
                    );

                    service.addDoctor(doctor);
                    break;

                case 3:

                    service.viewPatients();
                    break;

                case 4:

                    service.viewDoctors();
                    break;

                case 5:

                    int searchPid = readInt("Enter Patient ID: ");
                    service.searchPatient(searchPid);
                    break;

                case 6:

                    int searchDid = readInt("Enter Doctor ID: ");
                    service.searchDoctor(searchDid);
                    break;

                case 7:

                    int updateId = readInt("Enter Patient ID: ");

                    String updateName =
                        readText("Enter New Name: ");

                    int updateAge = readInt("Enter New Age: ");

                    String updateGender =
                        readText("Enter New Gender: ");

                    String updateDisease =
                        readText("Enter New Disease: ");

                    service.updatePatient(
                        updateId, updateName, updateAge,
                        updateGender, updateDisease
                    );

                    break;

                case 8:

                    int deleteId = readInt("Enter Patient ID: ");
                    service.deletePatient(deleteId);
                    break;

                case 9:

                    int aid = readInt("Enter Appointment ID: ");
                    int patientId = readInt("Enter Patient ID: ");
                    int doctorId = readInt("Enter Doctor ID: ");

                    String date = readText(
                        "Enter Appointment Date (DD-MM-YYYY): "
                    );

                    service.bookAppointment(
                        aid, patientId, doctorId, date
                    );

                    break;

                case 10:

                    service.viewAppointments();
                    break;

                case 11:

                    int billPatientId =
                        readInt("Enter Patient ID: ");

                    int billDoctorId =
                        readInt("Enter Doctor ID: ");

                    service.generateBill(
                        billPatientId, billDoctorId
                    );

                    break;

                case 12:

                    System.out.println(
                        "Thank you for using Hospital Management System!"
                    );

                    break;

                default:

                    System.out.println(
                        "Invalid choice! Please try again."
                    );
            }

        } while (choice != 12);

        sc.close();
    }
}
