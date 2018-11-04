
package bankomaten;

import java.util.ArrayList;
import java.util.List;

public class Account implements IInterest, IChangelog {
    private String accountNumber;
    private String accountType;
    private String conceder = "System Administrator";
    private int balance;
    private double interest;
    
    private List<Changelog> accountChangelog = new ArrayList<>();
    
    public Account(String accountNumber, String accountType, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        changeAccountType(accountType);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getBalance() {
        return balance;
    }
    
    public double getInterest() {
        return interest;
    }
    
    public void setInterest(String beviljare, double interest) {
        changelogAdd(beviljare, interest);
    }
    
    public void changeAccountType(String accountType) {
        this.accountType = accountType;
        
        switch (accountType) {
            case "Savingsaccount":
                interest = 1.01;
                break;
            case "Futureaccount":
                interest = 1.045;
                break;
            case "General Account":
                interest = 0;
                break;
        }
        
        changelogAdd(conceder, interest);
        }
    
    private void changelogAdd(String conceder, double interest) {
        Changelog changelog = new Changelog(conceder, interest, accountType);
        
        double tempInterest = 0;
        
        for (Changelog c : accountChangelog) {
            if (c.getAccountType().equals(accountType)) {
                tempInterest = c.getInterest();
            }
        }
        
        if (tempInterest != interest) {
            accountChangelog.add(changelog);   
        }
    }
    
    public void printChangelog() {
        for (Changelog c : accountChangelog) {
            c.printLog();
        }
    }
    
    public void calculateInterest(int years) {
        balance *= interest;
    }
}
