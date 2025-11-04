package com.example.application.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

// Importar las vistas
import com.example.application.views.usuarios.UsuariosView;
import com.example.application.views.libros.LibrosView;
import com.example.application.views.libros.CatalogoView;
import com.example.application.views.carrito.CarritoView;
import com.example.application.views.inicio.InicioView;

public class MainView extends AppLayout {

    public MainView() {
        // --- Encabezado ---
        H1 titulo = new H1("Tienda de Libros");
        titulo.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        DrawerToggle toggle = new DrawerToggle();
        addToNavbar(toggle, titulo);

        // --- Menú lateral ---
        VerticalLayout menu = new VerticalLayout();
        menu.setPadding(true);
        menu.setSpacing(true);

        RouterLink inicio = new RouterLink("Inicio", InicioView.class);
        RouterLink usuarios = new RouterLink("Usuarios", UsuariosView.class);
        RouterLink libros = new RouterLink("Libros", LibrosView.class);
        RouterLink catalogo = new RouterLink("Catálogo", CatalogoView.class);
        RouterLink carrito = new RouterLink("Carrito", CarritoView.class);

        menu.add(new Span("Navegación"), inicio, usuarios, libros, catalogo, carrito);
        addToDrawer(menu);
    }
}