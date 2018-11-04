
package bankomaten;

abstract public class Person {
    private String name;
    private String personnummer;
    private int age;
    
    public Person(String name, String personnummer) {
        this.name = name;
        this.personnummer = personnummer;
    }
    
    public String getName() {
        return name;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public int getAge() {
        return age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
