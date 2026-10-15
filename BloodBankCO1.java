
import java.util.Scanner;

public class BloodBankCO1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Project heading
        System.out.println("======================================");
        System.out.println("       LIFECARE BLOOD BANK");
        System.out.println("       CO1 - DONOR REGISTRATION");
        System.out.println("======================================");

        // Step 1: Read donor details
        System.out.print("Enter Donor ID: ");
        String donorId = sc.nextLine();

        System.out.print("Enter Donor Name: ");
        String donorName = sc.nextLine();

        System.out.print("Enter Blood Group: ");
        String bloodGroup = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Weight in kg: ");
        double weight = sc.nextDouble();

        System.out.print("Enter Number of Units Donated: ");
        int unitsDonated = sc.nextInt();

        // Step 2: Perform calculations
        // Assumption: 1 unit is represented as 450 ml
        int totalVolume = unitsDonated * 450;

        // Step 3: Display donor information
        System.out.println();
        System.out.println("======================================");
        System.out.println("         DONOR REGISTRATION");
        System.out.println("======================================");

        System.out.println("Donor ID       : " + donorId);
        System.out.println("Donor Name     : " + donorName);
        System.out.println("Blood Group    : " + bloodGroup);
        System.out.println("Age            : " + age + " years");
        System.out.println("Weight         : " + weight + " kg");
        System.out.println("Units Donated  : " + unitsDonated);
        System.out.println("Total Volume   : " + totalVolume + " ml");

        System.out.println("======================================");
        System.out.println("Registration details displayed.");
        System.out.println("======================================");

        sc.close();
    }
}
