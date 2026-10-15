
public class BloodBankCO3 {

    // Method to display blood bank inventory
    static void displayInventory(String[] bloodGroups, int[] units) {

        System.out.println("\nLIFECARE BLOOD BANK INVENTORY");
        System.out.println("-----------------------------");

        for (int i = 0; i < bloodGroups.length; i++) {
            System.out.println(bloodGroups[i] + " : " + units[i] + " units");
        }
    }

    // Method to calculate total units using recursion
    static int calculateTotal(int[] units, int index) {

        if (index == units.length) {
            return 0;
        }

        return units[index] + calculateTotal(units, index + 1);
    }

    public static void main(String[] args) {

        // Arrays to store blood groups and available units
        String[] bloodGroups = {"A+", "B+", "O+", "AB+"};
        int[] units = {50, 40, 60, 30};

        // Calling the display method
        displayInventory(bloodGroups, units);

        // Calling the recursive method
        int total = calculateTotal(units, 0);

        System.out.println("-----------------------------");
        System.out.println("Total blood units: " + total);
    }
}
