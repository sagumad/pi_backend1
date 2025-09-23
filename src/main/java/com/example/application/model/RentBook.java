package com.example.application.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RENT")
public class RentBook extends Book {

    private int rentalDays;

    public RentBook() {
        super();
    }

    public RentBook(String title, String author, double price, int rentalDays) {
        super(title, author, price);
        this.rentalDays = rentalDays;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    @Override
    public String getType() {
        return "RENT";
    }
}
