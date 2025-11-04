package com.example.application.views.libros;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.example.application.views.MainView;
import java.util.ArrayList;
import java.util.List;

@Route(value = "libros", layout = MainView.class)
public class LibrosView extends VerticalLayout {

    private List<Libro> libros;
    private Grid<Libro> grid;

    public LibrosView() {
        setPadding(true);
        setSpacing(true);

        // --- Título ---
        add(new com.vaadin.flow.component.html.H1("Lista de Libros"));

        // --- Datos de ejemplo ---
        libros = new ArrayList<>();
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry"));
        libros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez"));
        libros.add(new Libro("1984", "George Orwell"));

        // --- Tabla (Grid) ---
        grid = new Grid<>(Libro.class);
        grid.setItems(libros);

        // --- Botón para agregar libro ---
        Button agregar = new Button("Agregar libro", e -> {
            libros.add(new Libro("Nuevo libro", "Autor desconocido"));
            grid.getDataProvider().refreshAll();
        });

        add(agregar, grid);
    }

    // --- Clase interna Libro ---
    public static class Libro {
        private String titulo;
        private String autor;

        public Libro() {}

        public Libro(String titulo, String autor) {
            this.titulo = titulo;
            this.autor = autor;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }
    }
}