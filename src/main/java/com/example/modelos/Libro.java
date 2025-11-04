package com.example.modelos;

public class Libro {
    private final String id; 
    private String titulo;
    private String autor;
    private double precio;
    private boolean disponibleParaRenta;
    private String rutaPdfLocal; 

    public Libro(String id, String titulo, String autor, double precio, boolean disponibleParaRenta, String rutaPdfLocal) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.disponibleParaRenta = disponibleParaRenta;
        this.rutaPdfLocal = rutaPdfLocal;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public double getPrecio() { return precio; }
    public boolean isDisponibleParaRenta() { return disponibleParaRenta; }
    public String getRutaPdfLocal() { return rutaPdfLocal; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setDisponibleParaRenta(boolean disponibleParaRenta) { this.disponibleParaRenta = disponibleParaRenta; }
    public void setRutaPdfLocal(String rutaPdfLocal) { this.rutaPdfLocal = rutaPdfLocal; }

    @Override
    public String toString() {
        return titulo + " — " + autor + " (" + precio + ")";
    }
}