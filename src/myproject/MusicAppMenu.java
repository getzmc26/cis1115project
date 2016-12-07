package myproject;

import java.util.Scanner;
import utilities.Prompt;

/**
 * Text menu for interaction with Music Store list.
 *
 * @author Matt Getz
 */
public class MusicAppMenu {

    Scanner sc = new Scanner(System.in);
    DAOMusic data = new DAOMusic();

    public MusicAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        String instrument;
        String brand;
        String color;
        double price;

        while (choice != 0) {
            System.out.println("\nMusic Store App");
            System.out.println("---------------");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update Record");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Order by ID descending");
            System.out.println("7 = Retrieve All: Order by instrument A-Z");
            System.out.println("8 = Retrieve All: Order by instrument Z-A");
            System.out.println("9 = Retrieve All: Order by brand A-Z");
            System.out.println("10 = Retrieve All: Order by brand Z-A");
            System.out.println("11 = Retrieve All: Order by price ascending");
            System.out.println("12 = Retrieve All: Order by price descending");
            System.out.println("13 = Retrieve All: Order by instrument A-Z / price descending");
            System.out.println("14 = Retrieve All: Order by instrument A-Z / price ascending");
            System.out.println("15 = Retrieve All: Order by instrument Z-A / price descending");
            System.out.println("16 = Retrieve All: Order by instrument Z-A / price ascending");
            System.out.println("17 = Statistics");

            choice = Prompt.getInt("\nNumber of choice: ", 0, 17);

            if (choice == 1) {
                System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
                System.out.println("------------------------------------------------------------------------");
                System.out.println(data.toString());
            } else if (choice == 2) {
                id = Prompt.getInt("Enter instrument ID: ");
                instrument = Prompt.getLine("Enter instrument: ");
                brand = Prompt.getLine("Enter brand: ");
                color = Prompt.getLine("Enter color: ");
                price = Prompt.getDouble("Enter price: ");
                Music m1 = new Music(id, instrument, brand, color, price);
                data.create(m1);
            } else if (choice == 3) {
                id = Prompt.getInt("Enter instrument ID: ");
                System.out.println("");
                System.out.println(data.retrieve(id));
            } else if (choice == 4) {
                id = Prompt.getInt("Enter instrument ID: ");
                instrument = Prompt.getLine("Enter updated instrument: ");
                brand = Prompt.getLine("Enter updated brand: ");
                color = Prompt.getLine("Enter updated color: ");
                price = Prompt.getDouble("Enter updated price: ");
                Music m1 = new Music(id, instrument, brand, color, price);
                data.update(m1);
            } else if (choice == 5) {
                id = Prompt.getInt("Enter instrument ID of entry to be deleted: ");
                System.out.println("");
                System.out.println(data.retrieve(id));
                int count = 0;
                while (count < 1) {
                    System.out.print("\nDo you want to delete this entry?: ");
                    String answer = sc.nextLine();
                    if (answer.equalsIgnoreCase("y")) {
                        data.delete(id);
                        System.out.println("Entry at ID " + id + " has been deleted.");
                        count++;
                    }
                    else if (answer.equalsIgnoreCase("n")) {
                        System.out.println("\nDelete cancelled.");
                        count++;
                    }
                    else {
                        System.out.println("\nEnter 'y' for yes or 'n' for no.");
                    }
                }
            } else if (choice == 6) {
                System.out.println(data.orderByIDDescend());
            } else if (choice == 7) {
                System.out.println(data.orderByInstrumentAscend());
            } else if (choice == 8) {
                System.out.println(data.orderByInstrumentDescend());
            } else if (choice == 9) {
                System.out.println(data.orderByBrandAscend());
            } else if (choice == 10) {
                System.out.println(data.orderByBrandDescend());
            } else if (choice == 11) {
                System.out.println(data.orderByPriceAscend());
            } else if (choice == 12) {
                System.out.println(data.orderByPriceDescend());
            } else if (choice == 13) {
                System.out.println(data.orderByInstrumentAscendPriceDescend());
            } else if (choice == 14) {
                System.out.println(data.orderByInstrumentAscendPriceAscend());
            } else if (choice == 15) {
                System.out.println(data.orderByInstrumentDescendPriceDescend());
            } else if (choice == 16) {
                System.out.println(data.orderByInstrumentDescendPriceAscend());
            } else if (choice == 17) {
                System.out.println("\nStatistics: ");
                System.out.println(data.statistics());
            } else if (choice == 0) {
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        new MusicAppMenu();
    }
}
