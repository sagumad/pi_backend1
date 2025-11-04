package com.example.application.views.inicio;

import com.example.application.views.MainView;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Inicio")
@Route(value= "" , layout = MainView.class)
@Menu(order = 0, icon = LineAwesomeIconUrl.FILE)
public class InicioView extends VerticalLayout {

    public InicioView() {
        setSpacing(false);

        Image img = new Image("/images/descarga.jpeg", "placeholder plant");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("ESTA ES UNA TIENDA DE LIBROS");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph("Bienvenido a nuestra tienda de libros en línea. Aquí encontrarás una amplia selección de libros para todos los gustos y edades. Explora nuestras categorías, descubre nuevos autores y disfruta de ofertas exclusivas. ¡Feliz lectura!"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
