package com.example.application.views.inicio.tiendaLibros;

/**
 * Clase abstracta Libro.
 */
public abstract class Libro {

    private String titulo;
    private String autor;
    private String isbn;
    private double precioVenta;
    private double precioRenta;
    private boolean disponible;

    public Libro(String titulo, String autor, String isbn, double precioVenta, double precioRenta ,boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precioVenta = precioVenta;
        this.precioRenta = precioRenta;
        this.disponible = disponible;
    }

    // Encapsulamiento: getters y setters
    
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

    /**
     * Método polimórfico: cada subclase define cómo se calcula el precio final
     * dependiendo si es venta o renta.
     */

    public abstract double calcularPrecio(boolean esVenta);

    @Override
    public String toString() {
        return String.format("%s — %s (ISBN: %s)", titulo, autor, isbn);
    }
}
