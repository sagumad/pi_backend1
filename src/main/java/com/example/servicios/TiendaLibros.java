package com.example.servicios;

import com.example.interfaces.OperacionesTienda;
import com.example.modelos.Libro;
import java.util.ArrayList;
import java.util.List;

public class TiendaLibros implements OperacionesTienda {

    // aqui tenemos una lista de libros (simula una "base de datos")
    private List<Libro> inventario;

    public TiendaLibros() {
        inventario = new ArrayList<>();
    }

    @Override
    public void agregarLibro(Libro libro) {
        inventario.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    @Override
    public List<Libro> listarLibros() {
        return inventario;
    }

    @Override
    public void comprarLibro(Libro libro) {
        System.out.println("Has comprado el libro: " + libro.getTitulo());
    }

    @Override
    public void rentarLibro(Libro libro) {
        System.out.println("Has rentado el libro: " + libro.getTitulo() + ". Se guardará el PDF en localStorage (simulado).");
    }
}