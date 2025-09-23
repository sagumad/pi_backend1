package com.example.application.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SALE")
public class SaleBook extends Book {

    private String condition; // new, used

    public SaleBook() {
        super();
    }

    public SaleBook(String title, String author, double price, String condition) {
        super(title, author, price);
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String getType() {
        return "SALE";
    }
}
