
package hospital;

public class Billing {

    private static final double MEDICINE_CHARGES = 500.0;

    public void generateBill(Doctor doctor, Patient patient) {

        double consultationFee = doctor.getConsultationFee();

        double total = consultationFee + MEDICINE_CHARGES;

        System.out.println("\n========== HOSPITAL BILL ==========");
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Doctor Name: " + doctor.getName());

        System.out.println("Consultation Fee: Rs. " + consultationFee);
        System.out.println("Medicine Charges: Rs. " + MEDICINE_CHARGES);

        System.out.println("-----------------------------------");
        System.out.println("Total Amount: Rs. " + total);
        System.out.println("===================================");
    }
}
