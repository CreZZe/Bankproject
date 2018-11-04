
package bankomaten;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private String customerNumber;
    
    List<Account> accounts = new ArrayList<>();
    List<Loan> loans = new ArrayList<>();

    public Customer(String name, String personnummer, String customerNumber) {
        super(name, personnummer);
        this.customerNumber = customerNumber;
    }
    
    public String getCustomerNumber() {
        return customerNumber;
    }
    
    public void addAccount(Account account) {
        accounts.add(account);
    }
    
    public void addLoan(Loan loan) {
        loans.add(loan);
    }
    
    public void printKonton() {
        String str = "";
        int sum = 0;
        
        System.out.println(getName());
        for (Account a : accounts) {
            str += a.getAccountType() + " - " + a.getBalance() + "kr\n" + a.getAccountNumber() + "\n\n";
            sum += a.getBalance();
        }
        
        for (Loan l : loans) {
            str += "Beviljare: " + l.getBeviljare() + "\n" + l.getLoanID() + " - Balance: " + l.getBelopp() + "kr\n\n";
            sum += l.getBelopp();
        }
        System.out.println(str + "Total balance: " + sum + "kr");
    }
}
