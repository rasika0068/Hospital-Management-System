
package hospital;

public class Doctor extends Person {

    private String specialization;
    private double consultationFee;

    public Doctor(int id, String name, int age,
                  String gender, String specialization,
                  double consultationFee) {

        super(id, name, age, gender);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Specialization: " + specialization);
        System.out.println("Consultation Fee: " + consultationFee);
    }
}
