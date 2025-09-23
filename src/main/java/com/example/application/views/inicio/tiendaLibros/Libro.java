package com.example.application.views.inicio.tiendaLibros;

public abstract class Libro {

    private String titulo;
    private String autor;
    private String isbn;
    private Editorial editorial;
    private Categoria categoria;

    public Libro(String titulo, String autor, String isbn, Editorial editorial, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.categoria = categoria;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public Editorial getEditorial() { return editorial; }
    public Categoria getCategoria() { return categoria; }

    public abstract String getFormato();

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + editorial.getNombre() + ") [" + getFormato() + "]";
    }
}

