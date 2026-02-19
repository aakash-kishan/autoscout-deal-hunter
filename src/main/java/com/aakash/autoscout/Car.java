package com.aakash.autoscout;
import jakarta.persistence.*;
@Entity
public class Car {
    @Id // This is the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Double marketValue;
    @Column(name = "vehicle_condition")
    private String condition;

    public Car() {
    }

    public Car(Integer id, String name, Double price, Double marketValue, String condition) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.marketValue = marketValue;
        this.condition = condition;
    }

    public boolean isGreatDeal() {
        // Safety check: if price is missing, it's not a deal
        if (price == null || marketValue == null) return false;
        return price < (marketValue * 0.80);
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Double getMarketValue() { return marketValue; }
    public void setMarketValue(Double marketValue) { this.marketValue = marketValue; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
}