package com.example.application.views.libros;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import com.example.application.views.MainView;
import com.example.modelos.Libro;
import com.example.servicios.CatalogoServicio;
import com.example.servicios.CarritoServicio;

import java.util.List;

@Route(value = "catalogo", layout = MainView.class)
public class CatalogoView extends VerticalLayout {

    public CatalogoView() {
        setPadding(true);
        setSpacing(true);

        List<Libro> libros = CatalogoServicio.obtenerCatalogo();

        Grid<Libro> grid = new Grid<>(Libro.class, false);
        grid.addColumn(Libro::getTitulo).setHeader("Título");
        grid.addColumn(Libro::getAutor).setHeader("Autor");
        grid.addColumn(Libro::getPrecio).setHeader("Precio");
        grid.addColumn(l -> l.isDisponibleParaRenta() ? "Sí" : "No").setHeader("Disponible");

        // Botón "Agregar al carrito"
        grid.addComponentColumn(libro ->
            new Button("Agregar al carrito", e -> {
                CarritoServicio.agregarAlCarrito(libro);
                Notification.show("Libro agregado al carrito: " + libro.getTitulo());
            })
        ).setHeader("Acciones");

        grid.setItems(libros);
        add(grid);
    }
}