package com.example.servicios;

import com.example.modelos.Libro;
import java.util.ArrayList;
import java.util.List;

public class CatalogoServicio {

    private static final List<Libro> catalogo = new ArrayList<>();

    static {
        // Catálogo inicial de ejemplo
        catalogo.add(new Libro("1", "Cien años de soledad", "Gabriel García Márquez", 45.0, true, "archivos/cien_anos.pdf"));
        catalogo.add(new Libro("2", "Don Quijote de la Mancha", "Miguel de Cervantes", 50.0, true, "archivos/quijote.pdf"));
        catalogo.add(new Libro("3", "El principito", "Antoine de Saint-Exupéry", 30.0, false, "archivos/principito.pdf"));
    }

    public static List<Libro> obtenerCatalogo() {
        return catalogo;
    }

    public static Libro buscarPorId(String id) {
        return catalogo.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Libro> obtenerLibros() {
        List<Libro> lista = new ArrayList<>();
        lista.add(new Libro("1", "El Principito", "Antoine de Saint-Exupéry", 20.0, true, "libros/principito.pdf"));
        lista.add(new Libro("2", "Cien años de soledad", "Gabriel García Márquez", 35.0, false, "libros/cien.pdf"));
        lista.add(new Libro("3", "Don Quijote de la Mancha", "Miguel de Cervantes", 25.0, true, "libros/quijote.pdf"));
        return lista;
    }

}