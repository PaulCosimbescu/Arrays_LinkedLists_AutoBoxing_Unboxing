package BankingApplicationChallenge;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactionsArray;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactionsArray = new ArrayList<Double>();
        addTransaction(initialAmount);
    }


    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactionsArray() {
        return transactionsArray;
    }

    public void addTransaction(double transaction) {
        this.transactionsArray.add(transaction);
    }
}
