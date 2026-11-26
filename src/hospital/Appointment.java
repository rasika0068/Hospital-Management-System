package hospital;

public class Appointment {

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;

    public Appointment(int appointmentId, Patient patient,
                       Doctor doctor, String appointmentDate) {

        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void displayAppointment() {

        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Doctor Name: " + doctor.getName());
        System.out.println("Appointment Date: " + appointmentDate);
    }
}
