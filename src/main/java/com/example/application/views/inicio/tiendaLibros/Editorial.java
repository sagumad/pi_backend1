package com.example.application.views.inicio.tiendaLibros;

public class Editorial {
    
    private String nombre;
    private String ubicacion;
    private int anioFundacion;

    public Editorial(String nombre, String ubicacion, int anioFundacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.anioFundacion = anioFundacion;
    }

    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public int getAnioFundacion() { return anioFundacion; }
}
