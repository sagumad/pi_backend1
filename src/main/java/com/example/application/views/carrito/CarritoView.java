package com.example.application.views.carrito;

import com.example.modelos.Libro;
import com.example.servicios.CarritoServicio;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.example.application.views.MainView;
import java.util.List;

@Route(value = "carrito", layout = MainView.class)
public class CarritoView extends VerticalLayout {

    private final Grid<Libro> grid;

    public CarritoView() {
        setSpacing(true);
        setPadding(true);

        H2 titulo = new H2("🛒 Carrito de Compras");
        grid = new Grid<>(Libro.class);
        grid.setColumns("titulo", "autor", "precio");

        Button btnActualizar = new Button("Actualizar", e -> actualizarTabla());

        Button btnVaciar = new Button("Vaciar carrito", e -> {
            CarritoServicio.vaciarCarrito();
            actualizarTabla();
            Notification.show("El carrito ha sido vaciado");
        });

        Button btnComprar = new Button("Comprar", e -> {
            List<Libro> librosEnCarrito = CarritoServicio.obtenerCarrito();
            if (librosEnCarrito.isEmpty()) {
                Notification.show("Tu carrito está vacío");
            } else {
                CarritoServicio.vaciarCarrito();
                actualizarTabla();
                Notification.show("¡Compra realizada con éxito!");
            }
        });

        HorizontalLayout botones = new HorizontalLayout(btnActualizar, btnVaciar, btnComprar);
        add(titulo, botones, grid);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        actualizarTabla();
    }

    private void actualizarTabla() {
        List<Libro> libros = CarritoServicio.obtenerCarrito();
        grid.setItems(libros);
    }
}