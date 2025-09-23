package com.example.application.views.inicio;

import java.time.LocalDate;

public class Renta extends Transaccion {
    private LocalDate fechaDevolucion;
    private double precioRenta;
    private double multa;

    public Renta(int idTransaccion, int idCliente, int idLibro, LocalDate fecha, String estado, LocalDate fechaDevolucion, double precioRenta, double multa) {
        super(idTransaccion, idCliente, idLibro, fecha, estado);
        this.fechaDevolucion = fechaDevolucion;
        this.precioRenta = precioRenta;
        this.multa = multa;
    }

    @Override
    public double calcularTotal() {
        return precioRenta + multa;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("RENTA #" + idTransaccion +
                " | Cliente: " + idCliente +
                " | Libro: " + idLibro +
                " | Fecha Renta: " + fecha +
                " | Fecha Devolución: " + fechaDevolucion +
                " | Total: $" + calcularTotal() +
                " | Estado: " + estado);
    }
}
