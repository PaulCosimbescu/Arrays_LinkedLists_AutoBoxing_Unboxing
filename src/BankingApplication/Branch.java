package BankingApplication;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Branch {

    private ArrayList<Customer> myCustomer;
    private String branchCode;

    public Branch(String branchCode) {
        this.myCustomer = new ArrayList<Customer>();
        this.branchCode = branchCode;
    }

    public ArrayList<Customer> getMyCustomer() {
        return myCustomer;
    }

    public String getBranchCode() {
        return branchCode;
    }


    public boolean newCustomer(String customerName, double initialAmount) {
        if(findCustomer(customerName) == null) {
            this.myCustomer.add(new Customer(customerName, initialAmount));
            return true;
        }

        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }

        return false;
    }

    @Nullable
    private Customer findCustomer(String customerName) {
        for(int i = 0; i < myCustomer.size(); i++) {
            Customer checkCustomer = this.myCustomer.get(i);
            if(checkCustomer.getName().equals(customerName)) {
                return checkCustomer;
            }
        }
        return null;
    }







//    public boolean addNewCustomer(Customer customer) {
//        if(findCustomer(customer.getName()) >= 0) {
//            System.out.println("Customer is already on file. Can only add additional " +
//                    "transactions to this customer.");
//            return false;
//        }
//        myCustomer.add(customer);
//        return true;
//    }

//    public boolean addNewCustomer(String name) {
//        for (int i = 0; i < myCustomer.size(); i++) {
//            if (name.equals(myCustomer.get(i).getName())) {
//                System.out.println("Customer is already on file. Can only add additional " +
//                        "transactions to this customer.");
//                return false;
//            }
//        }
//        Customer customer = new Customer(name);
//        myCustomer.add(customer);
//        return true;
//    }
//
//    public boolean addNewTransaction(Customer customer, double money) {
//        if(findCustomer(customer.getName()) >= 0) {
//            System.out.println("Customer not found.");
//            return false;
//        }
//
//        customer.addTransaction(money);
//        return true;
//    }
//
//    private int findCustomer(String customerName) {
//        for(int i = 0; i < this.myCustomer.size(); i++) {
//            Customer customer = this.myCustomer.get(i);
//            if(customer.getName().equals(customerName)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public static Branch createBranch(String sortCode) {
//        return new Branch(sortCode);
//    }
//
//    public void printCustomers() {
//        System.out.println("Customer List");
//        for(int i = 0; i < myCustomer.size(); i++) {
//            System.out.println((i + 1) + ". " + this.myCustomer.get(i).getName());
//        }
//    }
}
