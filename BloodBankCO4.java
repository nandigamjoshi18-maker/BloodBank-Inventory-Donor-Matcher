
class Donor {

    // Private data members
    private int donorId;
    private String donorName;
    private String bloodGroup;
    private int age;

    // Parameterized constructor
    public Donor(int donorId, String donorName,
                 String bloodGroup, int age) {
        this.donorId = donorId;
        this.donorName = donorName;
        this.bloodGroup = bloodGroup;
        this.age = age;
    }

    // Getter methods
    public int getDonorId() {
        return donorId;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public int getAge() {
        return age;
    }

    // Display donor details
    public void displayDetails() {
        System.out.println("Donor ID: " + donorId);
        System.out.println("Donor Name: " + donorName);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Age: " + age);
    }
}

public class BloodBankCO4 {

    public static void main(String[] args) {

        // Creating a Donor object
        Donor donor1 = new Donor(
            101, "Joshi", "A+", 18
        );

        System.out.println("LIFECARE BLOOD BANK");
        System.out.println("-------------------");

        donor1.displayDetails();
    }
}
