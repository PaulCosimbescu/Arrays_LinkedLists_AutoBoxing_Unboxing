package BankingApplicationChallenge;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Bank bank = new Bank("HSBC");

        bank.addNewBranch("40-04-15");
        bank.addCustomer("40-04-15", "Tim", 50.05);
        bank.addCustomer("40-04-15", "Paul", 13243.22);
        bank.addCustomer("40-04-15", "Tudor", 220.0);

        bank.addNewBranch("44-04-15");
        bank.addCustomer("44-04-15", "Dan", 150.44);

        bank.addCustomerTransaction("40-04-15", "Paul", 10.44);
        bank.addCustomerTransaction("40-04-15", "Paul", 20.5);

        bank.listCustomers("40-04-15", true);
        bank.listCustomers("44-04-15", false);

        bank.addNewBranch("444");

        if(!bank.addCustomer("444", "Brian", 5.44)) {
            System.out.println("Error");
        }






//        boolean quit = false;
//
//        while(!quit) {
//            System.out.println("\nEnter action: (6 to show available actions)");
//            int action = scanner.nextInt();
//            scanner.nextLine();
//            switch (action) {
//                case 0:
//                    System.out.println("Quit application");
//                    quit = true;
//                    break;
//                case 1:
//                    addNewBranch();
//                    break;
//                case 2:
//                    addNewCustomer();
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    bank.printBranches();
//                    break;
//                case 5:
//                    branch.printCustomers();
//                    break;
//            }
//        }
    }


//    private static void addNewBranch() {
//        System.out.println("Enter new Sort Code for branch:");
//        String sortCode = scanner.nextLine();
//        Branch newBranch = Branch.createBranch(sortCode);
//        if(bank.addNewBranch(newBranch)) {
//            System.out.println("New Branch added with " + sortCode + " sort code. You must add a new Customer");
//            addNewCustomer();
//        } else {
//            System.out.println("Cannot add " + sortCode + ". Branch with that code already exits.");
//        }
//    }
//
//    private static void addNewCustomer() {
//        System.out.println("Enter new customer name: ");
//        String name = scanner.nextLine();
//
//        if(branch.addNewCustomer(name)) {
//            System.out.println("New customer added: " + name );
//        } else {
//            System.out.println("Cannot add " + name + " already on file");
//        }
//    }
//
//    private static void addTransaction() {
//        System.out.println("Enter the name of the customer that made the transaction:");
//        String name = scanner.nextLine();
////        Customer customer = Cu
//        System.out.println("Enter the transaction value:");
//        double transaction = scanner.nextDouble();
////        if(branch.addNewTransaction())
//    }
//
//
    private static void printAction() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - to shut down.\n" +
                "1 - to add a branch.\n" +
                "2 - to add a customer.\n" +
                "3 - to add a transaction.\n" +
                "4 - to remove an existing contact.\n" +
                "5 - to query if an existing contact exist.\n" +
                "6 - to print a list of available actions.\n");
        System.out.println("Choose your action: ");
    }
}
