package com.example.application.views;

import com.example.modelos.Usuario;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("registro")
public class RegistroView extends VerticalLayout {

    public RegistroView() {
        // Título
        H1 titulo = new H1("Registro de Usuario");

        // Campos del formulario
        TextField nombreField = new TextField("Nombre");
        TextField correoField = new TextField("Correo electrónico");
        PasswordField contrasenaField = new PasswordField("Contraseña");

        // Botón de registro
        Button registrarBtn = new Button("Registrar");

        registrarBtn.addClickListener(e -> {
            String nombre = nombreField.getValue();
            String correo = correoField.getValue();
            String contrasena = contrasenaField.getValue();

            if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
                Notification.show("Por favor completa todos los campos");
            } else {
                // Crea el usuario (usando tu modelo)
                Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);
                Notification.show("Usuario registrado: " + nuevoUsuario.getNombre());

                // Simula volver a inicio
                registrarBtn.getUI().ifPresent(ui -> ui.navigate(""));
            }
        });

        // Diseño visual
        FormLayout form = new FormLayout(nombreField, correoField, contrasenaField);
        add(titulo, form, registrarBtn);
        setAlignItems(Alignment.CENTER);
        setPadding(true);
        setSpacing(true);
    }
}