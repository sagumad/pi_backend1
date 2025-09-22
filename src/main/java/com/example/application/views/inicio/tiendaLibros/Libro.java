package com.example.application.views.inicio.tiendaLibros;

<<<<<<< HEAD
=======

>>>>>>> 7163112ad609972c9e3a8143edf88ad1190c01f5
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

<<<<<<< HEAD
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public Editorial getEditorial() { return editorial; }
    public Categoria getCategoria() { return categoria; }

    public abstract String getFormato();
=======
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioRenta() {
        return precioRenta;
    }

    public void setPrecioRenta(double precioRenta) {
        this.precioRenta = precioRenta;
    }

    public boolean getEstado() {
        return disponible;
    }

    public void setEstado(boolean estado) {
        this.disponible = estado;
    }


    public abstract double calcularPrecio(boolean esVenta);
>>>>>>> 7163112ad609972c9e3a8143edf88ad1190c01f5

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + editorial.getNombre() + ") [" + getFormato() + "]";
    }
}

