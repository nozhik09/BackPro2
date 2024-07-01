package de.ait;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Vlad", 28, "fdsfsd");


        System.out.println(person.getName());


        person.setAge(18);
        System.out.println(person);

        Person person1 = new Person("adasdsa");
      Person build =  Person.builder().name("dsa").age(5).build();

        System.out.println(build);
    }
}