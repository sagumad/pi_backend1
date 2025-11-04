package com.example.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario extends Persona {
    private String contrasena;
    private List<Libro> carrito;
    private boolean estaLogueado;

    public Usuario(String nombre, String correo, String contrasena) {
        super(nombre, correo);
        this.contrasena = contrasena;
        this.carrito = new ArrayList<>();
        this.estaLogueado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Libro> getCarrito() {
        return carrito;
    }

    public void agregarAlCarrito(Libro libro) {
        carrito.add(Objects.requireNonNull(libro));
    }

    public void vaciarCarrito() {
        carrito.clear();
    }

    public boolean isEstaLogueado() {
        return estaLogueado;
    }

    public void setEstaLogueado(boolean estaLogueado) {
        this.estaLogueado = estaLogueado;
    }

    @Override
    public String mostrarPerfil() {
        return "Usuario: " + nombre + " <" + correo + ">";
    }
}
