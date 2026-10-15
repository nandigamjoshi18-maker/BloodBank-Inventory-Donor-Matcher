
import java.util.Scanner;

public class BloodBankCO2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("       LIFECARE BLOOD BANK");
        System.out.println("       CO2 - CONTROL FLOW");
        System.out.println("==================================");
        System.out.println("1. Check Donor Eligibility");
        System.out.println("2. View Blood Group Information");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1/2/3): ");

        int choice = sc.nextInt();

        if (choice == 1) {

            System.out.print("Enter donor age: ");
            int age = sc.nextInt();

            System.out.print("Enter donor weight in kg: ");
            double weight = sc.nextDouble();

            if (age >= 18 && age <= 65 && weight >= 50) {
                System.out.println(
                    "The donor meets the project's basic eligibility rules."
                );
            } else {
                System.out.println(
                    "The donor does not meet the project's basic eligibility rules."
                );
            }

        } else if (choice == 2) {

            System.out.println("Common blood groups:");
            System.out.println("A+, A-, B+, B-, AB+, AB-, O+, O-");

        } else if (choice == 3) {

            System.out.println("Exiting Blood Bank CO2 module.");

        } else {

            System.out.println("Invalid choice. Please enter 1, 2, or 3.");
        }

        sc.close();
    }
}

