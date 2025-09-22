package com.example.application.views.inicio.tiendaLibros;

public class Categoria {
    
    private String nombre;
    private String subcategoria;
    private String descripcion;

    public Categoria(String nombre, String subcategoria, String descripcion) {
        this.nombre = nombre;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre + " - " + descripcion;
    }
}
