package HomeWork;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Person p1 = initiolaze();
        Person p2 = new Person();
        System.out.println(p1);
        System.out.println(p2);
        BeanUtils.assign(p1, p2);
        System.out.println("******************************************************************************************");
        System.out.println(p1);
        System.out.println(p2);

    }

    private static Person initiolaze() {
        Person person = new Person();
        person.setName("Vlad");
        person.setSurname("Grigorenko");
        person.setAgeOf(22);
        ArrayList<String> parentss = new ArrayList<>();
        parentss.add("Mother");
        parentss.add("Father");
        person.setParents(parentss);
        
        return person;
    }
}
