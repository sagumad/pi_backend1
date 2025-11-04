package com.example.servicios;

import com.example.modelos.Libro;
import java.util.ArrayList;
import java.util.List;

public class CarritoServicio {

    // --- Carrito compartido entre usuarios ---
    private static final List<Libro> carrito = new ArrayList<>();

    // Agregar libro al carrito
    public static void agregarAlCarrito(Libro libro) {
        carrito.add(libro);
    }

    // Obtener los libros del carrito
    public static List<Libro> obtenerCarrito() {
        return new ArrayList<>(carrito);
    }

    // Vaciar carrito
    public static void vaciarCarrito() {
        carrito.clear();
    }

    // Calcular el total
    public static double calcularTotal() {
        double total = 0;
        for (Libro libro : carrito) {
            total += libro.getPrecio();
        }
        return total;
    }
}