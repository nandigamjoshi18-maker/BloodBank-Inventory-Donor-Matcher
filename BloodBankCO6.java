
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BloodBankCO6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Collection to store donor names
        List<String> donors = new ArrayList<>();

        donors.add("Joshi");
        donors.add("Maahir");
        donors.add("Krishna");
        donors.add("Arjun");

        System.out.println("LIFECARE BLOOD BANK");
        System.out.println("-------------------");

        System.out.println("All donors:");
        donors.forEach(name -> System.out.println(name));

        // Lambda expression to sort donor names
        donors.sort((name1, name2) ->
            name1.compareToIgnoreCase(name2));

        System.out.println("\nDonors in alphabetical order:");
        donors.forEach(name -> System.out.println(name));

        // Functional interface and lambda expression
        System.out.print("\nEnter a donor name to search: ");
        String searchName = sc.nextLine().trim();

        java.util.function.Predicate<String> nameMatch =
            name -> name.equalsIgnoreCase(searchName);

        boolean found = donors.stream().anyMatch(nameMatch);

        if (found) {
            System.out.println("Donor found: " + searchName);
        } else {
            System.out.println("Donor not found.");
        }

        // Stream to filter names beginning with a chosen letter
        System.out.print(
            "\nEnter the starting letter to filter donors: "
        );
        String letter = sc.nextLine().trim();

        if (!letter.isEmpty()) {
            System.out.println("Matching donors:");

            donors.stream()
                .filter(name -> name.toLowerCase()
                    .startsWith(letter.toLowerCase()))
                .forEach(name -> System.out.println(name));
        }

        sc.close();
    }
}
