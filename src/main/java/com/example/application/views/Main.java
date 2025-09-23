package com.example.application.views;

import java.time.LocalDate;

import com.example.application.views.inicio.Renta;
import com.example.application.views.inicio.Venta;

public class Main {
    public static void main(String[] args) {
        Venta venta1 = new Venta(1, 101, 201, LocalDate.now(), "Completada", 2, 45000);
        Renta renta1 = new Renta(2, 102, 202, LocalDate.now(), "Activa", LocalDate.now().plusDays(7), 5000, 0);

        venta1.mostrarDetalle();
        renta1.mostrarDetalle();
    }
}
