package com.example.interfaces;

import com.example.modelos.Libro;
import java.util.List;

public interface OperacionesTienda {
    void agregarLibro(Libro libro);
    List<Libro> listarLibros();
    void comprarLibro(Libro libro);
    void rentarLibro(Libro libro);
}