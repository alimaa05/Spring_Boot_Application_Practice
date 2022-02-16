package com.alimaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

// to start your webserver you need this
@SpringBootApplication
// any method we have we can tell it to run any HTTP verbs
@RestController
public class HelloSpringBootApplication {

    public static void main(String[] args) {
        // this is the main access point of your application
        SpringApplication.run(HelloSpringBootApplication.class, args);

    }

    //localhost:8080
    // localhost is the root path
    @GetMapping
    String greet() {
        return "Hello Alimaa";
    }


    //http://localhost:8080/?name=alimaa
    // Hello Alimaa how are you today? - this prints
    @GetMapping(params = "name")
    // this is optional parameter
    String greetName(@RequestParam("name") String name) { //@requestParam - get the param in the parenthesis
        return "Hello " + name + " how are you today?";
    }

    // localhost:8080/ping
    //this is specifying a path
    // can't have the same method under the same path - can't have duplicates
    @GetMapping(path = "ping")
    // path = ping
    String ping() {
        return "pong";
    }

    // localhost:8080/foo
    @GetMapping(path = "foo")
    String foo() {
        return "bar";
    }

    //http://localhost:8080/people
    //{"name":"alex","age":24} prints this
    @GetMapping(path = "people")
    // path is the default that you put in parameters
    List<Person> getPerson() { // adding a list
        return List.of(
                new Person("alex", 24, true, List.of("burger", "pizza"), List.of()),
                new Person("wendy", 15, false, List.of(), List.of("Ford"))
        );

    }

    //POST method
    // as long as there's a different HTTP method, they can have the exact same path
    @PostMapping(path = "people")
    void addPerson(@RequestBody Person person) { // receiving person
        System.out.println(person); // printing person
    }

    static class Person {
        private String name;
        private Integer age;
        private Boolean isAdult;
        private List<String> favouriateFood;
        private List<String> cars;


        public Person(String name, Integer age, Boolean isAdult, List<String> favouriateFood, List<String> cars) {
            this.name = name;
            this.age = age;
            this.isAdult = isAdult;
            this.favouriateFood = favouriateFood;
            this.cars = cars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Boolean getAdult() {
            return isAdult;
        }

        public void setAdult(Boolean adult) {
            isAdult = adult;
        }

        public List<String> getFavouriateFood() {
            return favouriateFood;
        }

        public void setFavouriateFood(List<String> favouriateFood) {
            this.favouriateFood = favouriateFood;
        }

        public List<String> getCars() {
            return cars;
        }

        public void setCars(List<String> cars) {
            this.cars = cars;
        }


        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", isAdult=" + isAdult +
                    ", favouriateFood=" + favouriateFood +
                    ", cars=" + cars +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(isAdult, person.isAdult) && Objects.equals(favouriateFood, person.favouriateFood) && Objects.equals(cars, person.cars);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, isAdult, favouriateFood, cars);
        }
    }

}
