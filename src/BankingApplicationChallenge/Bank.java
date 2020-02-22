package BankingApplicationChallenge;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> myBranch;

    public Bank(String name) {
        this.name = name;
        this.myBranch = new ArrayList<Branch>();
    }

    public boolean addNewBranch(String branch) {
        if(findBranch(branch) == null) {
            this.myBranch.add(new Branch(branch));
            return true;
        }

        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName, amount);
        }

        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }

        return false;
    }

    @Nullable
    private Branch findBranch(String branchName) {
        for(int i = 0; i < myBranch.size(); i++) {
            Branch checkBranch = this.myBranch.get(i);
            if(checkBranch.getBranchCode().equals(branchName)) {
                return checkBranch;
            }
        }

        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            System.out.println("Customers for branch " + branch.getBranchCode());

            ArrayList<Customer> branchCustomers = branch.getMyCustomer();
            for(int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");

                if(showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactionsArray();

                    for(int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
