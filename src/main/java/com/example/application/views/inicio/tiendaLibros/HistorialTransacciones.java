package com.example.application.views.inicio.tiendaLibros;

import java.util.ArrayList;

class Cliente {
    private String id;
    private String nombre;
    private String correo;
    private String pais;

    public Cliente(String id, String nombre, String correo, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.pais = pais;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getPais() { return pais; }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " | Correo: " + correo + " | País: " + pais;
    }
}

class Transaccion {
    private String id;
    private String clienteId;
    private String libro;
    private double monto;

    public Transaccion(String id, String clienteId, String libro, double monto) {
        this.id = id;
        this.clienteId = clienteId;
        this.libro = libro;
        this.monto = monto;
    }

    public String getId() { return id; }
    public String getClienteId() { return clienteId; }
    public String getLibro() { return libro; }
    public double getMonto() { return monto; }

    @Override
    public String toString() {
        return "Transaccion: " + id + " | Libro: " + libro + " | Monto: $" + monto;
    }
}

class HistorialTransacciones {
    private ArrayList<Transaccion> transacciones;

    public HistorialTransacciones() {
        transacciones = new ArrayList<>();
    }

    public void agregarTransaccion(Transaccion t) {
        transacciones.add(t);
    }

    public void mostrarHistorial() {
        for (Transaccion t : transacciones) {
            System.out.println(t);
        }
    }

    public void mostrarHistorialDeCliente(String clienteId) {
        for (Transaccion t : transacciones) {
            if (t.getClienteId().equals(clienteId)) {
                System.out.println(t);
            }
        }
    }
}
