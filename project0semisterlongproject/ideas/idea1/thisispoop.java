package project0semisterlongproject.ideas.idea1;

import java.util.Scanner;

public class thisispoop {

    private static class NodeDonations {
        char typeOfDonations; // a for money, b for clothes, c for seeds/plants, d for other
        int amount; // For solid objects
        double moneyAmount; // For amount of money

        NodeDonations next;

        public NodeDonations(char typeOfDonations, int amount, double moneyAmount) {
            this.typeOfDonations = typeOfDonations;
            this.amount = amount;
            this.moneyAmount = moneyAmount;
            this.next = null;
        }
    }

    private static NodeDonations head = null;
    private static int totalVisitors = 0;
    private static double totalMoney = 0;
    private static int totalClothes = 0;
    private static int totalSeeds = 0;
    private static int totalOther = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Please select the amount of people in your group!");
        totalVisitors += Integer.parseInt(scanner.nextLine());

        String moreDonations = "yes";
        while (moreDonations.equalsIgnoreCase("yes")) {
            System.out.println("\nWhat kind of donation are you making?\nA: money\nB: clothing\nC: seeds/plants\nD: other items\nEnter here:");
            char donationType = scanner.nextLine().toUpperCase().charAt(0);

            switch (donationType) {
                case 'A':
                    System.out.println("How much have you donated?");
                    double amount = Double.parseDouble(scanner.nextLine());
                    System.out.println("Thank you for giving us $" + amount + "!");
                    addDonation(donationType, 0, amount);
                    break;
                case 'B':
                case 'C':
                case 'D':
                    System.out.println("How many " + (donationType == 'B' ? "clothing items" : donationType == 'C' ? "seeds/plants" : "other items") + " have you donated?");
                    int count = readValidInteger(scanner);
                    System.out.println("Thank you for giving us " + count + (donationType == 'B' ? " shirts!" : donationType == 'C' ? " nature items!" : " items!"));
                    addDonation(donationType, count, 0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }

            System.out.println("Do you have anything else to donate?");
            moreDonations = scanner.nextLine();
        }

        System.out.println("Thank you for donating!");
        displaySummary();
    }

    private static void addDonation(char type, int amount, double moneyAmount) {
        if (head == null) {
            head = new NodeDonations(type, amount, moneyAmount);
        } else {
            NodeDonations newNode = new NodeDonations(type, amount, moneyAmount);
            newNode.next = head;
            head = newNode;
        }

        switch (type) {
            case 'A':
                totalMoney += moneyAmount;
                break;
            case 'B':
                totalClothes += amount;
                break;
            case 'C':
                totalSeeds += amount;
                break;
            case 'D':
                totalOther += amount;
                break;
        }
    }

    private static void displaySummary() {
        System.out.println("\nTotal amount of people visited farm: " + totalVisitors);
        System.out.println("Total amount of money donated: $" + totalMoney);
        System.out.println("Total amount of clothes donated: " + totalClothes);
        System.out.println("Total amount of seeds/plants donated: " + totalSeeds);
        System.out.println("Total amount of other items donated: " + totalOther);
        System.out.println("===================================");
    }

    private static int readValidInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a solid number! Thanks! Press ESC to quit!");
            if (scanner.next().equalsIgnoreCase("ESC")) {
                return 0; // Assume 0 donations if the user chooses to quit
            }
        }
        return scanner.nextInt();
    }
}