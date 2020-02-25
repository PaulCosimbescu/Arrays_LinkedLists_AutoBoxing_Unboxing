package BankingApplication;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Double> transactionsArray;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactionsArray = new ArrayList<Double>();
        addTransaction(initialAmount);
    }


    public String getName() {
        return name;
    }

    public List<Double> getTransactionsArray() {
        return transactionsArray;
    }

    public void addTransaction(double transaction) {
        this.transactionsArray.add(transaction);
    }
}
