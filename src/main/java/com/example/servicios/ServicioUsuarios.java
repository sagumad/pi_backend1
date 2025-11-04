package com.example.servicios;

import com.example.modelos.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ServicioUsuarios {

    private List<Usuario> usuariosRegistrados;

    public ServicioUsuarios() {
        usuariosRegistrados = new ArrayList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuariosRegistrados.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    public Usuario iniciarSesion(String correo, String contrasena) {
        for (Usuario u : usuariosRegistrados) {
            if (u.getCorreo().equals(correo) && u.getContrasena().equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso para: " + u.getNombre());
                return u;
            }
        }
        System.out.println("Credenciales incorrectas.");
        return null;
    }
}