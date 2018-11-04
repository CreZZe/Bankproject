
package bankomaten;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    List<Employee> employees = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    
    public Bank(String name) {
        this.name = name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPersonal(Employee e) {
        employees.add(e);
    }

    public void setCustomer(Customer c) {
        customers.add(c);
    }
    
    public void printEmployees() {
        System.out.println("Employees: ");
        for (Employee e : employees) {
            System.out.println(e.getName());
        }
    }
    
    public void printCustomers() {
        System.out.println("Customers: ");
        for (Customer c : customers) {
            System.out.println(c.getName());
        }
    }
    
    public void printInfo() {
        System.out.println("Information from " + name);
        printEmployees();
        System.out.println("");
        printCustomers();
    }
}
