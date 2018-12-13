package HomeWork;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Integer ageOf;
    private String name;
    private String surname;


    public Person() {
        parents.add("Mom");
        parents.add("Dad");
    }
    private List<String> parents = new ArrayList<>();


    public List<String> getParents() {
        return parents;
    }

    public void setParents(List<String> parents) {
        this.parents = parents;
    }

    public Integer getAgeOf() {
        return ageOf;
    }

    public String getAgeOf(int i) { return "fdvx";}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return surname + " " + name;
    }

    public void setAgeOf(Integer age) {
        this.ageOf = age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String s = "Person{" +
                "ageOf=" + ageOf +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'';

        for (Object x : parents) {
            s += " " + x;
        }

        return s + "}";
    }
}
