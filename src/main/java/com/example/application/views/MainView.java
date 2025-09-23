package com.example.application.views;

import com.example.application.model.Book;
import com.example.application.model.RentBook;
import com.example.application.model.SaleBook;
import com.example.application.service.BookService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
// ...existing imports...
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@Route("libros")
@PageTitle("Libros")
public class MainView extends VerticalLayout {

    private final BookService bookService;
    private final Grid<Book> grid = new Grid<>(Book.class, false);

    public MainView(BookService bookService) {
        this.bookService = bookService;
        setSizeFull();
        addClassName("main-view");

        setupGrid();
        add(createCardsLayout(), createForm());
        updateList();
    }

    private void setupGrid() {
        grid.addColumn(Book::getId).setHeader("ID").setAutoWidth(true);
        grid.addColumn(Book::getTitle).setHeader("Título");
        grid.addColumn(Book::getAuthor).setHeader("Autor");
        grid.addColumn(Book::getType).setHeader("Tipo");
        grid.addColumn(b -> b.isAvailable() ? "Disponible" : "No disponible").setHeader("Estado");
        grid.addColumn(Book::getPrice).setHeader("Precio");
        grid.setSizeFull();
    }

    private HorizontalLayout createCardsLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidthFull();
        layout.setPadding(true);
        layout.setSpacing(true);
        layout.setAlignItems(FlexComponent.Alignment.START);

        for (Book b : bookService.findAll()) {
            VerticalLayout card = new VerticalLayout();
            card.addClassName("book-card");
            card.setWidth("220px");
            card.setPadding(true);
            Image img = new Image("images/empty-plant.png", "imagen");
            img.setWidth("180px");
            com.vaadin.flow.component.html.H4 title = new com.vaadin.flow.component.html.H4(b.getTitle());
            com.vaadin.flow.component.html.Span author = new com.vaadin.flow.component.html.Span(b.getAuthor());
            com.vaadin.flow.component.html.Span price = new com.vaadin.flow.component.html.Span(String.format("$ %.2f", b.getPrice()));

            Button buy = new Button("Comprar", e -> {
                if (!b.isAvailable()) {
                    Notification.show("No disponible");
                    return;
                }
                boolean ok = bookService.sellBook(b.getId());
                Notification.show(ok ? "Libro comprado" : "No se pudo comprar");
                updateList();
                getUI().ifPresent(ui -> ui.getPage().reload());
            });
            buy.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

            Button rent = new Button("Rentar", e -> {
                if (!b.isAvailable()) {
                    Notification.show("No disponible");
                    return;
                }
                Dialog d = new Dialog();
                d.add(new com.vaadin.flow.component.html.H5("Días de renta"));
                IntegerField days = new IntegerField();
                days.setValue(7);
                Button confirmar = new Button("Confirmar", ev -> {
                    int dias = days.getValue() == null ? 7 : days.getValue();
                    boolean ok = bookService.rentBook(b.getId(), dias);
                    Notification.show(ok ? "Libro rentado" : "No se pudo rentar");
                    d.close();
                    updateList();
                    getUI().ifPresent(ui -> ui.getPage().reload());
                });
                d.add(days, confirmar);
                d.open();
            });

            card.add(img, title, author, price, buy, rent);
            layout.add(card);
        }

        return layout;
    }

    private VerticalLayout createForm() {
        VerticalLayout form = new VerticalLayout();
        form.setWidthFull();

        TextField title = new TextField("Título");
        TextField author = new TextField("Autor");
        NumberField price = new NumberField("Precio");
        ComboBox<String> type = new ComboBox<>("Tipo");
        type.setItems("VENTA", "RENTA");
        TextField extra = new TextField("Condición / Días de renta");

        Button add = new Button("Agregar", e -> {
            String t = title.getValue();
            String a = author.getValue();
            double p = price.getValue() == null ? 0.0 : price.getValue();
            String ty = type.getValue();
            if (t.isEmpty() || a.isEmpty() || ty == null) {
                Notification.show("Rellene título, autor y tipo");
                return;
            }
            if ("VENTA".equals(ty)) {
                SaleBook sb = new SaleBook(t, a, p, extra.getValue());
                bookService.save(sb);
            } else {
                int days = 7;
                try {
                    days = Integer.parseInt(extra.getValue());
                } catch (Exception ex) {
                    days = 7;
                }
                RentBook rb = new RentBook(t, a, p, days);
                bookService.save(rb);
            }
            title.clear();
            author.clear();
            price.clear();
            extra.clear();
            updateList();
        });

        Button rent = new Button("Rentar seleccionado", e -> {
            Book b = grid.asSingleSelect().getValue();
            if (b == null) {
                Notification.show("Seleccione un libro para rentar");
                return;
            }
            boolean ok = bookService.rentBook(b.getId(), 7);
            Notification.show(ok ? "Libro rentado" : "No se puede rentar");
            updateList();
        });

        Button sell = new Button("Vender seleccionado", e -> {
            Book b = grid.asSingleSelect().getValue();
            if (b == null) {
                Notification.show("Seleccione un libro para vender");
                return;
            }
            boolean ok = bookService.sellBook(b.getId());
            Notification.show(ok ? "Libro vendido" : "No se puede vender");
            updateList();
        });

        HorizontalLayout actions = new HorizontalLayout(add, rent, sell);
        form.add(title, author, price, type, extra, actions);
        return form;
    }

    private void updateList() {
        grid.setItems(bookService.findAll());
    }
}
