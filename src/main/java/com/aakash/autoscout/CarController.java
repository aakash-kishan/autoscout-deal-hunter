package com.aakash.autoscout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired // Dependency Injection: Brings the Database Manager here
    private CarRepository repository;

    // 1. POST Request: Analyze & Save to DB
    @PostMapping("/analyze")
    public Car analyzeCar(@RequestBody Car car) {
        // Run logic
        if (car.isGreatDeal()) {
            // SAVE TO MYSQL DATABASE!
            repository.save(car);
            System.out.println("Saved to MySQL: " + car.getName());
        }
        return car;
    }

    // 2. GET Request: Load from DB
    @GetMapping("/garage")
    public List<Car> getGarage() {
        // FETCH FROM MYSQL DATABASE!
        return repository.findAll();
    }

    // 3. DELETE Request: Sell the Car (Remove from DB)
    @DeleteMapping("/garage/{id}")
    public void deleteCar(@PathVariable Integer id) {
        repository.deleteById(id);
        System.out.println("Deleted Car ID: " + id);
    }
}