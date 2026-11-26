
package hospital;

public class Patient extends Person {

    private String disease;

    public Patient(int id, String name, int age,
                   String gender, String disease) {

        super(id, name, age, gender);
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Disease: " + disease);
    }
}
