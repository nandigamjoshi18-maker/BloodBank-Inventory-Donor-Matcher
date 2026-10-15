
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.io.FileWriter;
import java.io.IOException;

class Donor {

    private int donorId;
    private String donorName;
    private String bloodGroup;
    private int age;
    private double weight;
    private int unitsDonated;

    public Donor(int donorId, String donorName,
                 String bloodGroup, int age,
                 double weight, int unitsDonated) {

        this.donorId = donorId;
        this.donorName = donorName;
        this.bloodGroup = bloodGroup;
        this.age = age;
        this.weight = weight;
        this.unitsDonated = unitsDonated;
    }

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

    public double getWeight() {
        return weight;
    }

    public int getUnitsDonated() {
        return unitsDonated;
    }

    public void displayDetails() {
        System.out.println("------------------------------");
        System.out.println("Donor ID: " + donorId);
        System.out.println("Donor Name: " + donorName);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Units Donated: " + unitsDonated);
    }
}

public class BloodBankIntegrated {

    static Scanner sc = new Scanner(System.in);

    // CO6: Collection to store donor objects
    static List<Donor> donors = new ArrayList<>();

    // CO3: Arrays for blood groups and inventory
    static String[] bloodGroups = {
        "A+", "A-", "B+", "B-",
        "AB+", "AB-", "O+", "O-"
    };

    static int[] inventory = {
        50, 20, 40, 15, 30, 10, 60, 25
    };

    // CO1 and CO2: Main menu and program control
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println("       LIFECARE BLOOD BANK");
            System.out.println("   INVENTORY & DONOR MATCHER");
            System.out.println("==================================");
            System.out.println("1. Register Donor");
            System.out.println("2. View All Donors");
            System.out.println("3. Search Donor by Name");
            System.out.println("4. View Blood Inventory");
            System.out.println("5. Sort Donors by Name");
            System.out.println("6. Filter Donors by Blood Group");
            System.out.println("7. Save Donor Records to File");
            System.out.println("8. Calculate Total Inventory");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {

                case 1:
                    registerDonor();
                    break;

                case 2:
                    displayAllDonors();
                    break;

                case 3:
                    searchDonor();
                    break;

                case 4:
                    displayInventory();
                    break;

                case 5:
                    sortDonors();
                    break;

                case 6:
                    filterDonors();
                    break;

                case 7:
                    saveRecords();
                    break;

                case 8:
                    System.out.println(
                        "Total inventory units: "
                        + calculateTotal(inventory, 0)
                    );
                    break;

                case 9:
                    System.out.println(
                        "Thank you for using LifeCare Blood Bank!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please enter 1 to 9."
                    );
            }

        } while (choice != 9);

        sc.close();
    }

    // Helper method for integer input
    static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid whole number: ");
            sc.next();
        }

        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    // CO4: Create and store a Donor object
    static void registerDonor() {

        System.out.println("\n--- DONOR REGISTRATION ---");

        System.out.print("Enter donor ID: ");
        int id = readInt();

        for (Donor donor : donors) {
            if (donor.getDonorId() == id) {
                System.out.println("Donor ID already exists.");
                return;
            }
        }

        System.out.print("Enter donor name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter blood group: ");
        String group = sc.nextLine().trim().toUpperCase();

        int groupIndex = getBloodGroupIndex(group);

        if (groupIndex == -1) {
            System.out.println("Invalid blood group.");
            return;
        }

        System.out.print("Enter donor age: ");
        int age = readInt();

        System.out.print("Enter donor weight in kg: ");
        double weight = readDouble();

        System.out.print("Enter units donated: ");
        int units = readInt();

        if (name.isEmpty() || age <= 0 ||
            weight <= 0 || units < 0) {
            System.out.println("Invalid donor details.");
            return;
        }

        Donor newDonor = new Donor(
            id, name, group, age, weight, units
        );

        donors.add(newDonor);

        // Update the sample inventory
        inventory[groupIndex] += units;

        System.out.println("Donor registered successfully!");
        System.out.println(
            "Note: Inventory updates are simulated for this project."
        );
    }

    static double readDouble() {
        while (!sc.hasNextDouble()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }

        double value = sc.nextDouble();
        sc.nextLine();
        return value;
    }

    // CO3: Display donor records using a method and loop
    static void displayAllDonors() {

        if (donors.isEmpty()) {
            System.out.println("No donors registered yet.");
            return;
        }

        System.out.println("\n--- ALL DONORS ---");

        for (Donor donor : donors) {
            donor.displayDetails();
        }
    }

    // CO5: String comparison and searching
    static void searchDonor() {

        System.out.print("Enter donor name to search: ");
        String searchName = sc.nextLine().trim();

        boolean found = false;

        for (Donor donor : donors) {
            if (donor.getDonorName()
                    .equalsIgnoreCase(searchName)) {

                donor.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Donor not found.");
        }
    }

    // CO3: Display inventory stored in arrays
    static void displayInventory() {

        System.out.println("\n--- BLOOD INVENTORY ---");

        for (int i = 0; i < bloodGroups.length; i++) {
            System.out.println(
                bloodGroups[i] + " : "
                + inventory[i] + " units"
            );
        }
    }

    // CO5 and CO6: Sort with a lambda expression
    static void sortDonors() {

        if (donors.isEmpty()) {
            System.out.println("No donors available to sort.");
            return;
        }

        donors.sort(
            Comparator.comparing(
                Donor::getDonorName,
                String.CASE_INSENSITIVE_ORDER
            )
        );

        System.out.println("\n--- DONORS SORTED BY NAME ---");

        donors.forEach(
            donor -> System.out.println(
                donor.getDonorName()
                + " - " + donor.getBloodGroup()
            )
        );
    }

    // CO6: Functional interface, lambda and Stream filter
    static void filterDonors() {

        System.out.print("Enter blood group to filter: ");
        String group = sc.nextLine().trim().toUpperCase();

        Predicate<Donor> groupMatch =
            donor -> donor.getBloodGroup().equalsIgnoreCase(group);

        List<Donor> matchingDonors = donors.stream()
            .filter(groupMatch)
            .toList();

        if (matchingDonors.isEmpty()) {
            System.out.println(
                "No donors found for blood group " + group
            );
        } else {
            System.out.println(
                "\nDonors with blood group " + group + ":"
            );

            matchingDonors.forEach(
                donor -> System.out.println(
                    donor.getDonorName()
                    + " (ID: " + donor.getDonorId() + ")"
                )
            );
        }
    }

    // CO1: Find the array index for a blood group
    static int getBloodGroupIndex(String group) {

        for (int i = 0; i < bloodGroups.length; i++) {
            if (bloodGroups[i].equalsIgnoreCase(group)) {
                return i;
            }
        }

        return -1;
    }

    // CO3: Recursion to calculate total inventory
    static int calculateTotal(int[] units, int index) {

        if (index >= units.length) {
            return 0;
        }

        return units[index]
            + calculateTotal(units, index + 1);
    }

    // CO5: Save donor records to a text file
    static void saveRecords() {

        try (FileWriter writer =
                 new FileWriter("donor_records.txt")) {

            writer.write("LIFECARE BLOOD BANK\n");
            writer.write("===================\n\n");

            for (Donor donor : donors) {
                writer.write(
                    "ID: " + donor.getDonorId() + "\n"
                    + "Name: " + donor.getDonorName() + "\n"
                    + "Blood Group: " + donor.getBloodGroup() + "\n"
                    + "Age: " + donor.getAge() + "\n"
                    + "Weight: " + donor.getWeight() + " kg\n"
                    + "Units Donated: "
                    + donor.getUnitsDonated() + "\n\n"
                );
            }

            System.out.println(
                "Donor records saved to donor_records.txt"
            );

        } catch (IOException e) {
            System.out.println(
                "Error saving records: " + e.getMessage()
            );
        }
    }
}
