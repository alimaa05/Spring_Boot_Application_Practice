package com.alimaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
// add @RestController to you expose methods as REST services to clients @RestController--> allows you to add annotations
public class SpringBootApplicationCounter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationCounter.class, args);


    }
// All your code should be inside this one class

    // create a variable static int count = 0;

    static int count = 0;

    // All methods should have a @GetMapping
    // Create a method to get current count. i.e localhost:8080/current-count

    @GetMapping(path = "current-count")
        // path is the thing that we have after the dash
    int currentCount() {
        return count; // returning count as it is
    }

    // Create method to increment the count. i.e localhost:8080/increment-count

    @GetMapping(path = "increment-count")
    int currentIncrement() {
        return count++; // incrementing
    }
// Create method to decrement the count. i.e localhost:8080/decrement-count

    @GetMapping(path = "decrement-count")
    int decrementCount() {
        return count--; // decrementing
    }


    // Test your api with chrome


}