package com.example.application.views.inicio.tiendaLibros;

public class Stock extends Libro {

    private int cantidad;

    public Stock(String titulo, String autor, String isbn, Editorial editorial, Categoria categoria, int cantidad) {
        super(titulo, autor, isbn, editorial, categoria);
        this.cantidad = Math.max(0, cantidad);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = Math.max(0, cantidad);
    }

    public boolean hayStock() {
        return cantidad > 0;
    }

    public boolean retirar(int unidades) {
        if (unidades <= 0) return false;
        if (cantidad >= unidades) {
            cantidad -= unidades;
            return true;
        }
        return false;
    }

    public void agregar(int unidades) {
        if (unidades > 0) {
            cantidad += unidades;
        }
    }

    @Override
    public String getFormato() {
        return "Stock";
    }
}
