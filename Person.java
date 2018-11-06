
package bankomaten;

abstract public class Person {
    private String name;
    private String personalIDNumber;
    private int age;
    
    public Person(String name, String personalIDNumber) {
        this.name = name;
        this.personalIDNumber = personalIDNumber;
    }
    
    public String getName() {
        return name;
    }

    public String getPersonalIDNumber() {
        return personalIDNumber;
    }

    public int getAge() {
        return age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
