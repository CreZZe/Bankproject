
package bankomaten;

public class Changelog {
    
    String beviljare;
    double interest;
    String accountType;
    
    public Changelog(String beviljare, double interest) {
        this.beviljare = beviljare;
        this.interest = interest;
    }
    
    public Changelog(String beviljare, double interest, String accountType) {
        this.beviljare = beviljare;
        this.interest = interest;
        this.accountType = accountType;
    }

    public String getBeviljare() {
        return beviljare;
    }

    public double getInterest() {
        return interest;
    }

    public String getAccountType() {
        return accountType;
    }
    
    public void printLog() {
        if (accountType != null) {
            System.out.println("Ändrad till " + interest + " för kontotyp " + accountType + ". Ändring utförd av " + beviljare);
        }
        else // Det är ett lån - FIXA
            System.out.println("");
    }
}
