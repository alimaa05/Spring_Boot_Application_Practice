package com.alimaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController  // add @RestController to you expose methods as REST services to clients
public class SpringBootApplicationPeople {

    // create a static List of type person with few people inside
    // list method --> making it a global scope so we can use it outside the main method
    static List<Person> getPerson = new ArrayList<>();


    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationPeople.class, args);

        // person object - needs to be in main
        Person connie = new Person(123, "Connie", 22);
        Person alimaa = new Person(345, "Alimaa", 22);
        Person suraya = new Person(456, "Suraya", 24);
        Person robyn = new Person(567, "Robyn", 23);
        Person suad = new Person(678, "Suad", 23);

        // calling the method and adding the person object
        getPerson.add(connie);
        getPerson.add(alimaa);
        getPerson.add(robyn);
        getPerson.add(suraya);
        getPerson.add(suad);

    }

    // implement getPersonById
//    need the @GetMapping

    // path variable is what goes after  / --> specifying what the path needs to be
    // id within {} means it's not a fixed number
    @GetMapping(path = "people/{id}")
    // path variable is id and its same as the id stated in the path variable - id is an integer
    public Person getPersonById(@PathVariable("id") Integer id) {

        // filter list and return person that matches id otherwise return null -->

        // need an enhanced for loop, looping through getPerson ArrayList
        // put it in the person placeholder of the Person object
        for (Person person : getPerson) {
            // if condition - if the id is equal to the person id then it will return that person
            if (id == person.getId()) {
                return person;
            }

        }// otherwise it will return null 
        return null;
    }


    // create another method that returns all people using @GetMapping("people")


    @GetMapping("allPeople") // allPeople is the path
    // creating a List method outside of the main that takes in Person method and its called 'getEveryone'
    // in the <> you can put anything but here we want to indicate that we want to only accept our Person method

    public List<Person> getEveryone() {
        // return  getPerson - our Person method
        return getPerson;

    }


// All your code should be inside this one class

    // create a class called Person with following properties: id, name, age
    static class Person {
        private int id;
        private String name;
        private int age;

        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, age);
        }
    }

// test your api using chrome

}



