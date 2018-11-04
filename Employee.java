
package bankomaten;

public class Employee extends Person {
    private String position;
    private int salary;

    public Employee(String name, String personnummer, String position, int salary) {
        super(name, personnummer);
        this.position = position;
        this.salary = salary;
    }
    
    public String getPosition() {
        return position;
    }
    
    public int getSalary() {
        return salary;
    }
}
