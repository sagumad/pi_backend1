package com.example.application.views.inicio.tiendaLibros;

public class LibroFisico extends Libro {

    private int numPaginas;
    private double peso;
    private String tipoDePasta;

    public LibroFisico(String titulo, String autor, String isbn, Editorial editorial, Categoria categoria,
            int numPaginas, double peso, String tipoDePasta) {
        super(titulo, autor, isbn, editorial, categoria);
        this.numPaginas = numPaginas;
        this.peso = peso;
        this.tipoDePasta = tipoDePasta;
    }

    public String getTipoDePasta() {
        return tipoDePasta;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String getFormato() {
        return "Físico";
    }
}
