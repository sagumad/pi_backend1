package com.example.application.views.inicio.tiendaLibros;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorVentas {
    
    
    public static class Transaccion {
        private String tipo; 
        private Libro libro;
        private Date fecha;

        public Transaccion(String tipo, Libro libro) {
            this.tipo = tipo;
            this.libro = libro;
            this.fecha = new Date(); 
        }

        @Override
        public String toString() {
            return "Transaccion{" +
                    "tipo='" + tipo + '\'' +
                    ", libro=" + libro.getTitulo() +
                    ", fecha=" + fecha +
                    '}';
        }
    }

    private List<Transaccion> historial;

    public GestorVentas() {
        this.historial = new ArrayList<>();
    }

    
    public void venderLibro(Libro libro) {
        Transaccion t = new Transaccion("venta", libro);
        historial.add(t);
        System.out.println("Libro vendido: " + libro.getTitulo());
    }

 
    public void rentarLibro(Libro libro) {
        Transaccion t = new Transaccion("renta", libro);
        historial.add(t);
        System.out.println("Libro rentado: " + libro.getTitulo());
    }

    
    public void mostrarHistorial() {
        System.out.println("===== Historial de Transacciones =====");
        for (Transaccion t : historial) {
            System.out.println(t);
        }
    }
}
