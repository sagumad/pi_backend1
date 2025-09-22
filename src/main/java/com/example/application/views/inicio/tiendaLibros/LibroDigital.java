package com.example.application.views.inicio.tiendaLibros;

public class LibroDigital extends Libro {

    private double tamanoMB;
    private String formatoArchivo;
    private int numPaginas;

    public LibroDigital(String titulo, String autor, String isbn, Editorial editorial, Categoria categoria,
            double tamanoMB, String formatoArchivo, int numPaginas) {
        super(titulo, autor, isbn, editorial, categoria);
        this.tamanoMB = tamanoMB;
        this.formatoArchivo = formatoArchivo;
        this.numPaginas = numPaginas;
    }

    public double getTamanoMB() {
        return tamanoMB;
    }

    public String getFormatoArchivo() {
        return formatoArchivo;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public String getFormato() {
        return "Digital (" + formatoArchivo + ")";
    }
}
