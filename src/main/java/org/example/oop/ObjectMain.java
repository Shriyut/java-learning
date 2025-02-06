package org.example.oop;

public class ObjectMain extends Object{ // inherited by default

    public static void main(String[] args) {
        SmStudent max = new SmStudent("Max", 25);
        System.out.println(max.toString()); //hashcode is created everytime an instance is created

        PrimarySchoolStudent jimmy = new PrimarySchoolStudent("Jimmy", 8, "John");
        System.out.println(jimmy); // inherits and calls toString method from SmStudent class if not overridden explicitly
    }

    public ObjectMain() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class SmStudent {
    private String name;
    private int age;

    SmStudent(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String toString() { //overrides toString from object class which returns classname@hexcode for object
        return "Name: " + name + ", Age: " + age;
    }
}

class PrimarySchoolStudent extends SmStudent {

    private String parentName;

    PrimarySchoolStudent(String name, int age, String parentName) {
        super(name, age); // calls SmStudent constructor
        this.parentName = parentName;
    }

    public String toString() {
        return super.toString() + ", Parent Name: " + parentName;
    }
}
