
package bankomaten;

public class Bankomaten {
        
    public void createDefault() {
        Bank Handelsbanken = new Bank("Handelsbanken");
        
        Account accountFuture1 = new Account("09-14339112", "Futureaccount", 200_000);
        Account accountFuture2 = new Account("09-18543366", "Futureaccount", 125_000);
        
        Account accountSavings1 = new Account("07-56555431", "Savingsaccount", 23000);
        Account accountSavings2 = new Account("07-92856466", "Savingsaccount", 830);
        
        
        Account accountGeneral1 = new Account("07-92856466", "Savingsaccount", 830);
        Account accountGeneral2 = new Account("07-92856466", "Savingsaccount", 830);
        
        Customer customerMikael = new Customer("Mikael Fredriksson", "980211", "0001");
        Customer customerPhilippa = new Customer("Philippa Ros", "981120", "0002");
        
        Employee employeeHampus = new Employee("Hampus Velander", "910323", "Banktjänsteman", 38000);
        Employee employeeOla = new Employee("Ola Tritton", "931124", "Banktjänsteman", 36500);
        
        Handelsbanken.setCustomer(customerMikael);
        Handelsbanken.setCustomer(customerPhilippa);
        
        Handelsbanken.setPersonal(employeeHampus);
        Handelsbanken.setPersonal(employeeOla);
        
        accountFuture1.setInterest("Sara Jakobsson", 1.25);
        accountFuture1.setInterest("Martin Henriksson", 1.12);
        accountFuture1.setInterest("Göta Davidsson", 1.14);        
        
        Loan loan1 = new Loan("0001", 450_000, 120);
        loan1.setBeviljare(employeeHampus);
        
        Loan loan2 = new Loan("0002", 120_000, 60);
        loan2.setBeviljare(employeeOla);
        
        Handelsbanken.printInfo();
    }
}
