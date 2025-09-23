package com.example.application.views.inicio;

import java.time.LocalDate;

public class Venta extends Transaccion {
    private int cantidad;
    private double precioUnitario;

    public Venta(int idTransaccion, int idCliente, int idLibro, LocalDate fecha, String estado, int cantidad, double precioUnitario) {
        super(idTransaccion, idCliente, idLibro, fecha, estado);
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    @Override
    public double calcularTotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("VENTA #" + idTransaccion +
                " | Cliente: " + idCliente +
                " | Libro: " + idLibro +
                " | Cantidad: " + cantidad +
                " | Total: $" + calcularTotal() +
                " | Estado: " + estado);
    }
}
