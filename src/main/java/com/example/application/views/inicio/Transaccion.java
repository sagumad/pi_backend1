package com.example.application.views.inicio;

import java.time.LocalDate;

// Clase abstracta
public abstract class Transaccion {
    protected int idTransaccion;
    protected int idCliente;
    protected int idLibro;
    protected LocalDate fecha;
    protected String estado;

    public Transaccion(int idTransaccion, int idCliente, int idLibro, LocalDate fecha, String estado) {
        this.idTransaccion = idTransaccion;
        this.idCliente = idCliente;
        this.idLibro = idLibro;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Métodos comunes
    public abstract double calcularTotal();
    public abstract void mostrarDetalle();
}