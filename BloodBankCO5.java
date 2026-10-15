
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BloodBankCO5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] donorNames = {
            "Maahir", "Joshi", "Krishna"
        };

        String[] bloodGroups = {
            "B+", "A+", "O+"
        };

        System.out.print("Enter donor name to search: ");
        String searchName = sc.nextLine().trim();

        boolean found = false;

        System.out.println("\nLIFECARE BLOOD BANK");
        System.out.println("-------------------");

        // Searching and comparing strings
        for (int i = 0; i < donorNames.length; i++) {

            if (donorNames[i].equalsIgnoreCase(searchName)) {

                System.out.println("Donor found!");
                System.out.println("Name: " +
                    donorNames[i].toUpperCase());
                System.out.println("Blood Group: " +
                    bloodGroups[i]);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Donor not found.");
        }

        // Sorting donor names alphabetically
        Arrays.sort(donorNames);

        System.out.println("\nDonor names in alphabetical order:");
        for (String name : donorNames) {
            System.out.println(name);
        }

        // Writing donor records to a file
        try {
            FileWriter writer =
                new FileWriter("donor_records.txt");

            writer.write("LIFECARE BLOOD BANK DONOR RECORDS\n");
            writer.write("---------------------------------\n");

            for (int i = 0; i < donorNames.length; i++) {
                writer.write("Donor Name: " +
                    donorNames[i] + "\n");
            }

            writer.close();

            System.out.println(
                "\nDonor names saved to donor_records.txt"
            );

        } catch (IOException e) {
            System.out.println(
                "Error writing to file: " + e.getMessage()
            );
        }

        sc.close();
    }
}
