package hospital;

import java.util.ArrayList;

public class HospitalService {

    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();

    // Add Patient
    public void addPatient(Patient patient) {

        if (findPatient(patient.getId()) != null) {
            System.out.println("Patient ID already exists!");
            return;
        }

        if (patient.getId() <= 0 || patient.getAge() <= 0) {
            System.out.println("Invalid patient ID or age!");
            return;
        }

        if (patient.getName().trim().isEmpty()
                || patient.getDisease().trim().isEmpty()) {
            System.out.println("Patient details cannot be empty!");
            return;
        }

        patients.add(patient);
        System.out.println("Patient registered successfully!");
    }

    // Add Doctor
    public void addDoctor(Doctor doctor) {

        if (findDoctor(doctor.getId()) != null) {
            System.out.println("Doctor ID already exists!");
            return;
        }

        if (doctor.getId() <= 0 || doctor.getAge() <= 0) {
            System.out.println("Invalid doctor ID or age!");
            return;
        }

        if (doctor.getConsultationFee() < 0) {
            System.out.println("Invalid consultation fee!");
            return;
        }

        if (doctor.getName().trim().isEmpty()
                || doctor.getSpecialization().trim().isEmpty()) {
            System.out.println("Doctor details cannot be empty!");
            return;
        }

        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    // Find Patient
    public Patient findPatient(int id) {

        for (Patient p : patients) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    // Find Doctor
    public Doctor findDoctor(int id) {

        for (Doctor d : doctors) {
            if (d.getId() == id) {
                return d;
            }
        }

        return null;
    }

    // Display Patients
    public void viewPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patients found!");
            return;
        }

        for (Patient p : patients) {
            p.displayDetails();
            System.out.println("----------------------");
        }
    }

    // Display Doctors
    public void viewDoctors() {

        if (doctors.isEmpty()) {
            System.out.println("No doctors found!");
            return;
        }

        for (Doctor d : doctors) {
            d.displayDetails();
            System.out.println("----------------------");
        }
    }

    // Search Patient
    public void searchPatient(int id) {

        Patient p = findPatient(id);

        if (p != null) {
            System.out.println("Patient Found:");
            p.displayDetails();
        } else {
            System.out.println("Patient not found!");
        }
    }

    // Search Doctor
    public void searchDoctor(int id) {

        Doctor d = findDoctor(id);

        if (d != null) {
            System.out.println("Doctor Found:");
            d.displayDetails();
        } else {
            System.out.println("Doctor not found!");
        }
    }

    // Update Patient
    public void updatePatient(int id, String name,
                              int age, String gender,
                              String disease) {

        Patient p = findPatient(id);

        if (p == null) {
            System.out.println("Patient not found!");
            return;
        }

        if (name.trim().isEmpty() || age <= 0
                || gender.trim().isEmpty()
                || disease.trim().isEmpty()) {
            System.out.println("Invalid patient details!");
            return;
        }

        p.setName(name);
        p.setAge(age);
        p.setGender(gender);
        p.setDisease(disease);

        System.out.println("Patient updated successfully!");
    }

    // Delete Patient
    public void deletePatient(int id) {

        Patient p = findPatient(id);

        if (p == null) {
            System.out.println("Patient not found!");
            return;
        }

        for (Appointment a : appointments) {
            if (a.getPatient().getId() == id) {
                System.out.println(
                    "Cannot delete patient with existing appointments!"
                );
                return;
            }
        }

        patients.remove(p);
        System.out.println("Patient deleted successfully!");
    }

    // Book Appointment
    public void bookAppointment(int appointmentId,
                                int patientId,
                                int doctorId,
                                String date) {

        if (appointmentId <= 0 || date.trim().isEmpty()) {
            System.out.println("Invalid appointment details!");
            return;
        }

        for (Appointment a : appointments) {
            if (a.getAppointmentId() == appointmentId) {
                System.out.println("Appointment ID already exists!");
                return;
            }
        }

        Patient patient = findPatient(patientId);
        Doctor doctor = findDoctor(doctorId);

        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        if (doctor == null) {
            System.out.println("Doctor not found!");
            return;
        }

        Appointment appointment = new Appointment(
            appointmentId, patient, doctor, date
        );

        appointments.add(appointment);

        System.out.println("Appointment booked successfully!");
    }

    // View Appointments
    public void viewAppointments() {

        if (appointments.isEmpty()) {
            System.out.println("No appointments found!");
            return;
        }

        for (Appointment a : appointments) {
            a.displayAppointment();
            System.out.println("----------------------");
        }
    }

    // Generate Bill
    public void generateBill(int patientId, int doctorId) {

        Patient patient = findPatient(patientId);
        Doctor doctor = findDoctor(doctorId);

        if (patient == null || doctor == null) {
            System.out.println("Invalid patient or doctor ID!");
            return;
        }

        new Billing().generateBill(doctor, patient);
    }
}
