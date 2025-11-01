package student.honig.roey;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        CashRegister register = new CashRegister();

        while (running) {
            System.out.println("==== Cash Register Menu ====");
            System.out.println("1. Add an item");
            System.out.println("2. Present current bill");
            System.out.println("3. Checkout");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            // Handle the user’s choice
            switch (choice) {
                case 1:
                    addItem(scanner, register);
                    break;
                case 2:
                    String currentBill = register.toString();
                    printBill(currentBill);
                    break;
                case 3:
                    boolean cartIsEmpty = register.accountTotal() == 0;
                    String finalBill = register.toString();
                    if (!cartIsEmpty) {
                        checkOut(scanner, register, finalBill);
                        break;
                    } else {
                        printBill(finalBill);
                        break;
                    }
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void checkOut(Scanner scanner, CashRegister register, String finalBill) {
        System.out.println("Your total cost fot this purchase is: " + register.accountTotal());
        System.out.println("Please enter the amount of payment: ");
        double payment = scanner.nextDouble();
        double change = register.bill(payment);
        if (change < 0) {
            System.out.println("Not enough money!!!");
        } else {
            printBill(finalBill);
            System.out.println("Thank you for your purchase, your change is: " + change);
        }
    }

    private static void addItem(Scanner scanner, CashRegister register) {
        scanner.nextLine();
        System.out.println("Item's name:");
        String iName = scanner.nextLine();
        System.out.println("Item's price:");
        double iValue = scanner.nextDouble();
        System.out.println("How many items?");
        int iAmount = scanner.nextInt();
        register.addItem(iName, iValue, iAmount);
    }

    private static void printBill(String bill) {
        System.out.println();
        System.out.println("******************");
        System.out.println(bill);
        System.out.println("******************");
    }
}
