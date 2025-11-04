package com.example.application.views.usuarios;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.example.application.views.MainView;

import java.util.ArrayList;
import java.util.List;

@Route(value = "usuarios", layout = MainView.class)
public class UsuariosView extends VerticalLayout {

    private List<Usuario> usuarios = new ArrayList<>();
    private Grid<Usuario> grid = new Grid<>(Usuario.class);

    public UsuariosView() {
        setPadding(true);
        setSpacing(true);

        usuarios.add(new Usuario("Samuel", "samuel@example.com"));
        usuarios.add(new Usuario("Laura", "laura@example.com"));

        grid.setItems(usuarios);

        Button agregar = new Button("Agregar usuario", e -> {
            usuarios.add(new Usuario("Nuevo", "nuevo@correo.com"));
            grid.getDataProvider().refreshAll();
        });

        add(agregar, grid);
    }

    // Clase interna simple
    public static class Usuario {
        private String nombre;
        private String email;

        public Usuario(String nombre, String email) {
            this.nombre = nombre;
            this.email = email;
        }

        public String getNombre() { return nombre; }
        public String getEmail() { return email; }
    }
}