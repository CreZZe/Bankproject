
package bankomaten;

import java.util.ArrayList;
import java.util.List;

public class Loan implements IInterest {
    private String loanID;
    private int months;
    private double belopp;
    private double startBelopp;
    private double interest;
    private double loanPaybackMonthly;
    private double loanPaybackTotal;
    private Employee beviljare;
    
    private List<Changelog> loanChangelog = new ArrayList<>();

    public Loan(String loanID, double belopp, int months) {
        this.loanID = loanID;
        this.belopp = belopp;
        this.months = months;
        setInterest();
    }
    
    public String getLoanID() {
        return loanID;
    }

    public double getBelopp() {
        return belopp;
    }
    
    public double getInterest() {
        return interest;
    }
    
    public void setBelopp(int belopp) {
        this.belopp = belopp;
    }
    
    public void setBeviljare(Employee personal) {
        beviljare = personal;
    }

    public String getBeviljare() {
        return beviljare.getName();
    }
    
    private void setInterest() {
        if (startBelopp < 5000 && startBelopp >= 0)
            interest = 1.11;
        else if (startBelopp >= 5000 && startBelopp < 50000)
            interest = 1.10;
        else if (startBelopp >= 50000 && startBelopp < 100000)
            interest = 1.09;
        else if (startBelopp >= 100000 && startBelopp < 500000)
            interest = 1.08;
        else
            interest = 1.07;
        
        loanPaybackMonthly = (startBelopp * interest) / this.months;
        loanPaybackTotal = startBelopp * interest;
    }
    
    
    /**
     * 60 months = ett helt lån
     * @param years 
     */
    public void calculateInterest(int months) {
        double tempPayback = loanPaybackMonthly * months;
        System.out.println(Math.round(tempPayback) + "kr / " + Math.round(interest) + "kr");
    }
    
     private void changelogAdd(String beviljare, double interest) {
        Changelog changelog = new Changelog(beviljare, interest);
        
        double tempInterest = 0;
        
        for (Changelog c : loanChangelog) {
            tempInterest = c.getInterest();
        }
        
        if (tempInterest != interest) {
            loanChangelog.add(changelog);   
        }
    }
     
    public void setInterest(String beviljare, double interest) {
        
        //Resterande belopp som ska betalas ska ökas om räntan ökar
        this.interest = interest;
        changelogAdd(beviljare, interest);
    }
    
    public void printChangelog() {
        for (Changelog c : loanChangelog) {
            c.printLog();
        }
    }
}
